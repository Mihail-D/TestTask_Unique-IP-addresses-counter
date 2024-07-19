import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileReader {

    private static final Logger LOGGER = Logger.getLogger(FileReader.class.getName());
    private static final String FILE_PATH = "./src/main/resources/ip.txt";
    Map<String, Integer> ipCountMap = new HashMap<>();
    Runtime runtime = Runtime.getRuntime();
    int linesRead = 0;
    final int linesThreshold = 10000;
    int uniqueIpCount = 0;

    public void readLinesFromFile() {
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Validator.validateLine(line);
                ipCountMap.put(line, ipCountMap.getOrDefault(line, 0) + 1);
                linesRead++;

                if (linesRead % linesThreshold == 0) {
                    runtime.gc();
                }
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "An exception occurred while reading the file", e);
        }

        for (Integer i : ipCountMap.values()) {
            if (i == 1) {
                uniqueIpCount++;
            }
        }

        System.out.println("Количество уникальных IP адресов: " + uniqueIpCount);
    }

}
