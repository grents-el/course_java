

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CombinedData {
    private List<Lines> lines;
    private List<Stations> stations;
    private List<String> jsonLines;
    private List<DatesStationOpened> csvLines;


    public CombinedData(List<Lines> lines, List<Stations> stations, List<String> jsonLines, List<DatesStationOpened> csvLines) {
        this.lines = lines;
        this.stations = stations;
        this.jsonLines = jsonLines;
        this.csvLines = csvLines;
    }
    public void generateJSONFile(String filename) {
        JSONArray stationArray = new JSONArray();
        for (Stations station :stations) {

            JSONObject stationObj = new JSONObject();
            stationObj.put("name", station.getStName());
            stationObj.put("line", getLineName(station.stNum));
            stationObj.put("date", getOpeningDate(station.getStName()));
            stationObj.put("depth", getStationDepth(station.getStName()));
            stationObj.put("hasConnection",station.hasTransition);
            stationArray.add(stationObj);
        }
        JSONObject dataObj=new JSONObject();
        dataObj.put("stations",stationArray);
        try (FileWriter file = new FileWriter(filename)) {
            file.write(dataObj.toJSONString());
            file.flush();
            System.out.println("JSON file created: " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void generatorStJSONFile(String filename){
        JSONArray stationArray=new JSONArray();
        JSONArray linesArray=new JSONArray();

        for (Lines line :lines) {
            JSONObject stationObj = new JSONObject();
            JSONObject stationObj1 = new JSONObject();
            stationObj1.put("number",line.getLineNum());
            stationObj1.put("name",line.getLineName());
            stationObj.put(line.getLineNum(),getStName(line.getLineNum()));
            stationArray.add(stationObj);
            linesArray.add(stationObj1);
        }
        JSONObject dataObj=new JSONObject();
        dataObj.put("stations",stationArray);
        dataObj.put("lines",linesArray);

        try (FileWriter file = new FileWriter(filename)) {
            file.write(dataObj.toJSONString());
            file.flush();
            System.out.println("JSON file created: " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<String> getStName(String lineNum) {
        List<String> stAll=new ArrayList<>();
        for (Stations station : stations) {
            if (station.getStNum().equals(lineNum)) {
                stAll.add(station.getStName());

            }
        }
        return stAll;
    }
    private String getLineName(String lineNum) {
        for (Lines line : lines) {
            if (line.getLineNum().equals(lineNum)) {
                return line.getLineName();
            }
        }
        return "";
    }

    public String getOpeningDate(String stationName) {

        for (DatesStationOpened station : csvLines) {
            if (station.getStationName().equals(stationName)) {
                return station.getDate();
            }
        }
        return "";
    }

    public String getStationDepth(String stationName) {
        for (String line : jsonLines) {
            if (line.contains(stationName)) {
                String[] fragments = line.split(" ");
                return fragments[fragments.length - 1];
            }
        }
        return "";
    }}