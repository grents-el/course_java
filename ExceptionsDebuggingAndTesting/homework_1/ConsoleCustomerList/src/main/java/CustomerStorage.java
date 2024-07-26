import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class CustomerStorage {
    private final Map<String, Customer> storage;
    private static final Logger logger = LogManager.getLogger(CustomerStorage.class);
    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;

        String[] components = data.split("\\s+");

            if(components.length != 4){
                logger.log(Level.ERROR,"Кол-во введенных данных не равно 4.");
                throw new ArrayIndexOutOfBoundsException("Введен некоректный формат даннных.");
            }
            if (!components[INDEX_EMAIL].matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")){
                logger.log(Level.ERROR,"Некоректный формат почты .");
                throw new IllegalArgumentException("Некорректный формат e-mail.");
            }
            if (!components[INDEX_PHONE].matches("\\+7\\d{10}")){
                logger.log(Level.ERROR,"Некоректный формат  телефона.");
                throw  new IllegalArgumentException("Некорректный формат номера телефона.");
            }
            String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
            storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
        }


    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }
}