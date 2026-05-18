package validation;

public class CommandValidator {

    /**
     * Проверява дали подаденият вход е валиден integer ID.
     *
     * @param input входен текст
     * @return цяло число
     * @throws IllegalArgumentException ако входът не е число
     */
    public static int validateId(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("ID must be an integer.");
        }
    }
}