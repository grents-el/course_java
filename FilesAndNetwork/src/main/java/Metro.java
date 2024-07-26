

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Metro {
    public  Map<String,String> numberLineName;
    public  List<Lines> lines;
    public  String parseFile(String htmlFile){
        StringBuilder builder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(htmlFile));
            lines.forEach(line->builder.append(line+"\n"));
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return builder.toString();
    }

    public List<Lines> getLines(){
        numberLineName = new LinkedHashMap<>();
        lines = new ArrayList<>();
        String htmlFile = parseFile("data/code.html");
        Document doc = Jsoup.parse(htmlFile);
        Elements elements = doc.select("span.js-metro-line");
        elements.forEach(element -> {
            String lineName= element.select("span.js-metro-line").text();
            String lineNum =element.attr("data-line");
            Lines line = new Lines(lineName,lineNum);
            lines.add(line);
        });
        return lines;
    }
    public List<Stations> getStations(){
        List<Stations> stations = new ArrayList<>();
        String htmlFile = parseFile("data/code.html");
        Document doc = Jsoup.parse(htmlFile);
        Elements elements = doc.select("div.js-metro-stations");
        for (Element element:elements){
            String stNum = element.attr("data-line");
            Elements elements1=element.select("p.single-station");
            for (Element element1:elements1){
                Elements stName = element1.select("span.name");
                String staName = "";
                for (Element line1 : stName) {
                    boolean hasTransition = element1.select("span.t-icon-metroln").isEmpty();
                    staName = line1.text();
                    Stations st = new Stations(staName, stNum, null, null, !hasTransition);
                    stations.add(st);
                }}

        }
        return stations;
    }

    }



