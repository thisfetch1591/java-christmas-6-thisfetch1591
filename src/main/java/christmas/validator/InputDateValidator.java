package christmas.validator;

public class InputDateValidator {

    public static int validateDate(String input) {
        int date = convertStringToInt(input);
        validateRange(date);
        return date;
    }

    private static int convertStringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateRange(int date) {
        if (date < 1 || date > 31) {
            throw new IllegalArgumentException();
        }

    }
}
