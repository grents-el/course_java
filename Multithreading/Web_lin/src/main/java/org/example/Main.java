package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;
public class Main {

    private static final String BASE_URL = "https://skillbox.ru/";
    private static final int PARALLELISM = 16;
    private static final int MAX_DEPTH = 50;
    private static final int WAIT_TIME_MS = 100;

    private static final Set<String> visitedLinks = new HashSet<>();
    private static final ForkJoinPool forkJoinPool = new ForkJoinPool(PARALLELISM);

    public static void main(String[] args) {
        forkJoinPool.invoke(new CrawlTask(BASE_URL, 0));
        forkJoinPool.shutdown();
        try {
            forkJoinPool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static class CrawlTask extends RecursiveAction {
        private final String url;
        private final int depth;

        public CrawlTask(String url, int depth) {
            this.url = url;
            this.depth = depth;
        }

        @Override
        protected void compute() {
            if (visitedLinks.contains(url) || depth > MAX_DEPTH) {
                return;
            }

            visitedLinks.add(url);
            try {
                Document doc = Jsoup.connect(url).get();
                Elements links = doc.select("a[href^=" + BASE_URL + "]");

                writeToFile(url, depth);

                for (Element link : links) {
                    String childUrl = link.attr("abs:href");
                    CrawlTask task = new CrawlTask(childUrl, depth + 1);
                    task.fork();
                }

                Thread.sleep(WAIT_TIME_MS);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void writeToFile(String url, int depth) {
        try {
            String indents = "\t".repeat(depth);
            BufferedWriter writer = new BufferedWriter(new FileWriter("map.txt", true));
            writer.write(indents + url + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}