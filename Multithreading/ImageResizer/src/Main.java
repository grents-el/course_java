import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main {
    private static int cores = Runtime.getRuntime().availableProcessors();
    public static void main(String[] args) {
        String srcFolder = "C:/NEED/images/src";
        String dstFolder = "C:/NEED/images/dst";
        File srcDir = new File(srcFolder);
        File[] files = srcDir.listFiles();
        long start = System.currentTimeMillis();
        int part = (files.length + cores - 1) / cores;

        int position = 0;
        ImageResizer[] resizerThreads = new ImageResizer[cores];
        for (int i = 0; i < cores; i++) {
            int remaining = files.length - position;
            int currentPart = Math.min(part, remaining);
            File[] files1 = new File[currentPart];
            System.arraycopy(files, position, files1, 0, currentPart);
            position += currentPart;
            ImageResizer resizer = new ImageResizer(files1, dstFolder, start);
            resizerThreads[i] = resizer;
            resizer.start();
        }


        for (ImageResizer thread : resizerThreads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        long end = System.currentTimeMillis();
        long totalTime = end - start;
        System.out.println("Total running time of all threads: " + totalTime + " ms");
    }
}
