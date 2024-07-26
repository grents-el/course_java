import java.util.NoSuchElementException;
import java.util.Scanner;
import org.apache.logging.log4j.*;


public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);
    private static final String ADD_COMMAND = "add Василий Петров " +
            "vasily.petrov@gmail.com +79215637722";
    private static final String COMMAND_EXAMPLES = "\t" + ADD_COMMAND + "\n" +
            "\tlist\n\tcount\n\tremove Василий Петров";
    private static final String COMMAND_ERROR = "Wrong command! Available command examples: \n" +
            COMMAND_EXAMPLES;
    private static final String helpText = "Command examples:\n" + COMMAND_EXAMPLES;

    public static void main(String[] args) {
        logger.error("123test");
        logger.log(Level.ERROR,"Сообщение об !!!! ошибке");
        logger.log(Level.INFO,"Сообщение об !! запросе");
        Scanner scanner = new Scanner(System.in);
        CustomerStorage executor = new CustomerStorage();

        while (true) {
            String command = scanner.nextLine();
            String[] tokens = command.split("\\s+", 2);
            switch (tokens[0]){
                case "add":
                    try {

                        executor.addCustomer(tokens[1]);
                        logger.info("Запрос add");
                    } catch (ArrayIndexOutOfBoundsException e){
                        logger.log(Level.ERROR,"Кол-во введенных данных не равно 4.");
                    } catch (IllegalArgumentException e){
                        logger.log(Level.ERROR,"Некоректный формат почты или телефона.");
                    }
                    break;
                case "list":
                    try{
                        executor.listCustomers();
                        logger.info("Запрос list");
                    } catch (NoSuchElementException e){
                        logger.log(Level.ERROR,"Список пуст.");

                    }
                    break;
                case  "remove":
                    executor.removeCustomer(tokens[1]);
                    logger.info("Запрос remove");
                    break;
            }

            switch (tokens[0]) {
                case "add":
                    executor.addCustomer(tokens[1]);
                    break;
                case "list":
                    executor.listCustomers();
                    break;
                case "remove":
                    executor.removeCustomer(tokens[1]);
                    break;
                case "count":
                    System.out.println("There are " + executor.getCount() + " customers");
                    break;
                case "help":
                    System.out.println(helpText);
                    break;
                default:
                    System.out.println(COMMAND_ERROR);
                    break;
            }
        }
    }
}
