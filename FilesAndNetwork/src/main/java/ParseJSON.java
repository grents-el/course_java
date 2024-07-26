

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ParseJSON {
    public static List<String> parseJSONFiles(List<String> files) {
        List<String> jsonLines = new ArrayList<>();

        for (String file : files) {
            try {
                byte[] jsonData = Files.readAllBytes(Paths.get(file));
                String jsonString = new String(jsonData);
                JSONParser parser = new JSONParser();
                JSONArray data = (JSONArray) parser.parse(jsonString);

                for (Object obj : data) {
                    JSONObject jsonObj = (JSONObject) obj;
                    String name = (String) jsonObj.get("station_name");
                    String depth = getDepth(jsonObj);
                    String all = name + " " + depth;
                    jsonLines.add(all);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return jsonLines;
    }

    protected static String getDepth(JSONObject jsonObj) {
        String depth = "";
        if (jsonObj.containsKey("depth")) {
            depth = (jsonObj.get("depth").toString());
        }
        return String.valueOf(depth);
    }
}
