import java.util.Hashtable;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class Bank {
    ConcurrentHashMap<String, Account> accounts = new ConcurrentHashMap<>();
    private final Random random = new Random();

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount) throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    public void transfer(String fromAccountNum, String toAccountNum, long amount) {
        Account fromAccount = accounts.get(fromAccountNum);
        Account toAccount = accounts.get(toAccountNum);

        if (fromAccount == null || toAccount == null) {
            throw new IllegalArgumentException("Invalid account numbers");
        }

        Account firstAccount, secondAccount;

        if (fromAccountNum.compareTo(toAccountNum) < 0) {
            firstAccount = fromAccount;
            secondAccount = toAccount;
        } else {
            firstAccount = toAccount;
            secondAccount = fromAccount;
        }

        synchronized (firstAccount) {
            synchronized (secondAccount) {
                if (fromAccount.isBlocked() || toAccount.isBlocked()) {
                    return;
                }

                if (amount > 50000) {
                    boolean isFraudulent = false;
                    try {
                        isFraudulent = isFraud(fromAccountNum, toAccountNum, amount);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if (isFraudulent) {
                        blockAccounts(fromAccountNum, toAccountNum);
                        return;
                    }
                }

                if (fromAccount.getMoney() >= amount) {
                    accounts.compute(fromAccountNum, (accNumber, account) -> {
                        account.setMoney(account.getMoney() - amount);
                        return account;
                    });

                    accounts.compute(toAccountNum, (accNumber, account) -> {
                        account.setMoney(account.getMoney() + amount);
                        return account;
                    });
                } else {
                    throw new IllegalArgumentException("Insufficient funds");
                }
            }
        }
    }

    public void blockAccounts(String... accountNums) {
        for (String accountNum : accountNums) {
            Account account = accounts.get(accountNum);
            if (account != null) {
                account.setBlocked(true);
            }
        }
    }

    public long getBalance(String accountNum) {
        Account account = accounts.get(accountNum);
        if (account != null) {
            return account.getMoney();
        }
        throw new IllegalArgumentException("Invalid account number");
    }

    public long getSumAllAccounts() {
        return accounts.values().stream()
                .mapToLong(Account::getMoney)
                .sum();
    }
}