import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FileReaderTest {

    FileReader fileReader;
    private static final String INVALID_FILE_PATH = "./src/main/resources/invalid_ip.txt";
    private static final String FILE_PATH = "./src/main/resources/ip.txt";

    @Test
    void testReadLinesFromFile() {
        fileReader = new FileReader(FILE_PATH);
        fileReader.readLinesFromFile();
        assertEquals(1, fileReader.uniqueIpCount);
    }

    @Test
    void testReadLinesFromFileWithInvalidIp() {
        fileReader = new FileReader(INVALID_FILE_PATH);
        assertThrows(IllegalArgumentException.class, () -> fileReader.readLinesFromFile());
    }

    @Test
    void testReadLinesFromFileWithInvalidFilePath() {
        fileReader = new FileReader("invalid_file_path");
        assertThrows(IllegalArgumentException.class, () -> fileReader.readLinesFromFile());
    }

    @Test
    void testReadLinesFromFileWithNullFilePath() {
        fileReader = new FileReader(null);
        assertThrows(IllegalArgumentException.class, () -> fileReader.readLinesFromFile());
    }

    @Test
    void testReadLinesFromFileWithEmptyFilePath() {
        fileReader = new FileReader("");
        assertThrows(IllegalArgumentException.class, () -> fileReader.readLinesFromFile());
    }

    @Test
    void testReadLinesFromFileWithNullIp() {
        fileReader = new FileReader("./src/main/resources/null_ip.txt");
        assertThrows(IllegalArgumentException.class, () -> fileReader.readLinesFromFile());
    }

    @Test
    void testReadLinesFromFileWithEmptyIp() {
        fileReader = new FileReader("./src/main/resources/empty_ip.txt");
        assertThrows(IllegalArgumentException.class, () -> fileReader.readLinesFromFile());
    }
}
