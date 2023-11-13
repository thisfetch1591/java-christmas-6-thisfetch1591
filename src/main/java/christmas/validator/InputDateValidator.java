package christmas.validator;

public class InputDateValidator {

    public static int validateRange(int date) {
        if (date < 1 || date > 31) {
            throw new IllegalArgumentException();
        }
        return date;
    }
}
