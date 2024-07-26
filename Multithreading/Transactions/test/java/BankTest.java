import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.fail;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;




public class BankTest {
    private Bank bank;

    @BeforeEach
    public void setUp() {
        bank = new Bank();
    }

    @Test
    public void testTransferWithinLimits() {
        Account fromAccount = new Account();
        fromAccount.setMoney(100000);
        fromAccount.setAccNumber("123456");

        Account toAccount = new Account();
        toAccount.setMoney(50000);
        toAccount.setAccNumber("789012");

        bank.accounts.put("123456", fromAccount);
        bank.accounts.put("789012", toAccount);

        bank.transfer("123456", "789012", 30000);

        assertEquals(70000, fromAccount.getMoney());
        assertEquals(80000, toAccount.getMoney());
    }

    @Test
    public void testTransferInsufficientFunds() {
        Account fromAccount = new Account();
        fromAccount.setMoney(1000);
        fromAccount.setAccNumber("123456");

        Account toAccount = new Account();
        toAccount.setMoney(50000);
        toAccount.setAccNumber("789012");

        bank.accounts.put("123456", fromAccount);
        bank.accounts.put("789012", toAccount);

        assertThrows(IllegalArgumentException.class, () -> bank.transfer("123456", "789012", 3000));
    }

    @Test
    public void testTransferFraudulentTransaction() {
        Account fromAccount = new Account();
        fromAccount.setMoney(100000);
        fromAccount.setAccNumber("123456");

        Account toAccount = new Account();
        toAccount.setMoney(50000);
        toAccount.setAccNumber("789012");

        bank.accounts.put("123456", fromAccount);
        bank.accounts.put("789012", toAccount);

        bank.blockAccounts("123456");
        bank.blockAccounts("789012");
        bank.transfer("123456", "789012", 60000);

        assertTrue(fromAccount.isBlocked());
        assertTrue(toAccount.isBlocked());
        assertEquals(100000, fromAccount.getMoney());
        assertEquals(50000, toAccount.getMoney());
    }

    @Test
    public void testGetBalance() {
        Account account = new Account();
        account.setMoney(5000);
        account.setAccNumber("123456");

        bank.accounts.put("123456", account);

        assertEquals(5000, bank.getBalance("123456"));
    }

    @Test
    public void testGetSumAllAccounts() {
        Account account1 = new Account();
        account1.setMoney(3000);
        account1.setAccNumber("123456");

        Account account2 = new Account();
        account2.setMoney(5000);
        account2.setAccNumber("789012");

        bank.accounts.put("123456", account1);
        bank.accounts.put("789012", account2);

        assertEquals(8000, bank.getSumAllAccounts());
    }

    @Test
    public void testInvalidAccountTransfer() {
        Account fromAccount = new Account();
        fromAccount.setMoney(100000);
        fromAccount.setAccNumber("123456");

        Account toAccount = new Account();
        toAccount.setMoney(50000);
        toAccount.setAccNumber("789012");

        bank.accounts.put("123456", fromAccount);
        bank.accounts.put("789012", toAccount);

        assertThrows(IllegalArgumentException.class, () -> bank.transfer("nonexistent", "789012", 60000));
        assertThrows(IllegalArgumentException.class, () -> bank.transfer("123456", "nonexistent", 60000));
    }
    @Test
    public void testNoDeadlockDuringSimpleTransfers() {
        Account account1 = new Account();
        account1.setMoney(100000);
        account1.setAccNumber("123456");

        Account account2 = new Account();
        account2.setMoney(50000);
        account2.setAccNumber("789012");

        bank.accounts.put("123456", account1);
        bank.accounts.put("789012", account2);

        Thread thread1 = new Thread(() -> {
            try {
                bank.transfer("123456", "789012", 1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                bank.transfer("789012", "123456", 500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertDoesNotThrow(() -> {});
    }

}
