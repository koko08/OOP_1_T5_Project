package validation;

public class CommandValidator {

    public static int validateId(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("ID must be an integer.");
        }
    }
}