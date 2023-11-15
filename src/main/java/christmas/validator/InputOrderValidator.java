package christmas.validator;

import static christmas.constants.ErrorType.CAN_NOT_ORDER_NUMBER;

import christmas.constants.Menu;

public class InputOrderValidator {

    private static final int QUANTITY_MIN_NUMBER = 0;
    public static Menu validateExistMenuName(String name) {
        try {
            return Menu.find(name);
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

    public static void validateRangeQuantity(int quantity) {
        if (quantity < QUANTITY_MIN_NUMBER) {
            throw new IllegalArgumentException(CAN_NOT_ORDER_NUMBER.getErrorMessage());
        }
    }
}
