import java.io.File;
import java.util.regex.Pattern;

public class Validator {

    private static final Pattern IP_ADDRESS_PATTERN =
            Pattern.compile("^([0-9]{1,3}\\.){3}[0-9]{1,3}$");

    public static void validateLine(String line) throws IllegalArgumentException {
        if (!IP_ADDRESS_PATTERN.matcher(line).matches()) {
            throw new IllegalArgumentException("Представленная строка " + line + " не является IP адресом");
        }
    }

    public static void validateFilePath(String filePath) throws IllegalArgumentException {
        if (filePath == null || !new File(filePath).exists() ) {
            throw new IllegalArgumentException("Файл по указанному пути не найден");
        }
    }
}
