package christmas.validator;

import static christmas.constants.ErrorType.DATE_RANGE_IS_NOT_VALIDATE;

public class InputDateValidator {

    private final static int MIN_DATE = 1;
    private final static int MAX_DATE = 31;

    public static int validateRange(int date) {
        if (date < MIN_DATE || date > MAX_DATE) {
            throw new IllegalArgumentException(DATE_RANGE_IS_NOT_VALIDATE.getErrorMessage());
        }
        return date;
    }
}
