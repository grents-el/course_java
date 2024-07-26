

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ParseCSV {
    private static DateTimeFormatter formatter;
    private List<DatesStationOpened> csvLines;

    public ParseCSV() {
        formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        csvLines = new ArrayList<>();
    }

    public List<DatesStationOpened> getCsv(List<String> files) {
        for (String file : files) {
            try {
                List<String> lines = Files.readAllLines(Paths.get(file));
                lines.remove(0);
                for (String line : lines) {
                    String[] frag = line.split(",");
                    LocalDate localDate = LocalDate.parse(frag[1], formatter);
                    String dateConvert = localDate.format(formatter).trim();
                    csvLines.add(new DatesStationOpened(frag[0], dateConvert));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return csvLines;
    }
}
