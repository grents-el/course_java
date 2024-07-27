import java.io.FileWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public  class Loader {

    public static void main(String[] args) {
       int numberT=Runtime.getRuntime().availableProcessors();
       int maxRegionCode=99;
       int part= maxRegionCode/numberT;
       ExecutorService executor= Executors.newFixedThreadPool(numberT);
       int first;
       int end=1;
       for (int i=1;i<numberT;i++){
           String path="res/number"+i+".txt";
           first=end;
           if(i==numberT){
               end=maxRegionCode+1;
           } else {
               end=first+part;
           }
           int First=first;
           int End=end;
           executor.execute(() -> run(path, First, End));
       }
        executor.shutdown();
    }


    protected static String padNumber(int number, int numberLength) {
        StringBuilder numberStr =new StringBuilder(Integer.toString(number));
        int padSize = numberLength - numberStr.length();

        for (int i = 0; i < padSize; i++) {
            numberStr.insert(0,'0');
        }
        return numberStr.toString();
    }

    private static void run(String path, int first, int end){
        long start = System.currentTimeMillis();
        try {
            FileWriter writer = new FileWriter(path);
            char[] letters = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};
            for (int regionCode=first; regionCode<end;regionCode++) {
                StringBuilder builder= new StringBuilder();
                for (int number = 1; number < 1000; number++) {
                    for (char firstLetter : letters) {
                        for (char secondLetter : letters) {
                            for (char thirdLetter : letters) {
                                builder.append(firstLetter);
                                builder.append(padNumber(number,3));
                                builder.append(secondLetter);
                                builder.append(thirdLetter);
                                builder.append(padNumber(regionCode,2));
                                builder.append("\n");
                            }
                        }
                    }
                }
                writer.write(builder.toString());
            }

            writer.flush();
            writer.close();


        } catch (Exception e){
            throw new RuntimeException(e);
        }
        System.out.println((System.currentTimeMillis() - start) + " ms");
    }
}
