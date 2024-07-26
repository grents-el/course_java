

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        String file ="data/data3";
        FindFiles findFiles = new FindFiles(file);
       Metro metro = new Metro();
        List<Lines> lines = metro.getLines();
        List<Stations> stations = metro.getStations();
        ParseJSON parseJSON = new ParseJSON();
        List<String> jsonLines = parseJSON.parseJSONFiles(findFiles.getNameJSONFiles());
        ParseCSV parseCSV = new ParseCSV();
        List<DatesStationOpened> csvLines = parseCSV.getCsv(findFiles.getNameCSVFiles());
        CombinedData combinedData = new CombinedData(lines, stations, jsonLines, csvLines);
        combinedData.generateJSONFile("data/output.json");
        combinedData.generatorStJSONFile("data/output-1.json");

    }
    }













