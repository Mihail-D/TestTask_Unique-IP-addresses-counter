import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileReader {

    private static final Logger LOGGER = Logger.getLogger(FileReader.class.getName());
    private final String filePath;
    Map<String, Integer> ipCountMap = new HashMap<>();
    Runtime runtime = Runtime.getRuntime();
    int linesRead = 0;
    final int linesThreshold = 10000;
    int uniqueIpCount = 0;

    public FileReader(String filePath) {
        this.filePath = filePath;
    }

    public void readLinesFromFile() {
        Validator.validateFilePath(this.filePath);

        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(this.filePath))) {
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
            LOGGER.log(Level.SEVERE, "Возникло исключение при чтении файла", e);
        }

        for (Integer i : ipCountMap.values()) {
            if (i == 1) {
                uniqueIpCount++;
            }
        }

        System.out.println("Количество уникальных IP адресов: " + uniqueIpCount);
    }

}
