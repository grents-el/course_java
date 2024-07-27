public class Main {
    public static void main(String[] args) {
        Container container = new Container();
        container.addCount(5672);
        System.out.println(container.getCount());

        // TODO: ниже напишите код для выполнения задания:
        //  С помощью цикла и преобразования чисел в символы найдите все коды
        //  букв русского алфавита — заглавных и строчных, в том числе буквы Ё.
        char first = 'А';
        int firstCode = first;
        char last = 'я';
        int lastCode = last;
        char yoSmall = 'ё';
        int yoSmallCode = yoSmall;
        char yoBig = 'Ё';
        int yoBigCode = yoBig;
        for (int i = firstCode;i<=lastCode;i++){
            char c = (char) i;
            System.out.println(i+ " - " + c);
        }
        System.out.println(yoSmallCode + " - ё" );
        System.out.println(yoBigCode + " - Ё");


    }
}
