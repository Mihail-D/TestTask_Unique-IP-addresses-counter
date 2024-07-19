import java.util.regex.Pattern;

public class Validator {

    private static final Pattern IP_ADDRESS_PATTERN =
            Pattern.compile("^([0-9]{1,3}\\.){3}[0-9]{1,3}$");

    public static void validateLine(String line) throws IllegalArgumentException {
        if (!IP_ADDRESS_PATTERN.matcher(line).matches()) {
            throw new IllegalArgumentException("The provided string " + line + " does not match the IP address " +
                    "pattern.");
        }
    }
}
