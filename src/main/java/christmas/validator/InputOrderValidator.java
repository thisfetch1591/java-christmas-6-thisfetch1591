package christmas.validator;

import christmas.constants.Menu;

public class InputOrderValidator {
    public static Menu validateExistMenuName(String name) {
        try {
            return Menu.find(name);
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException();
        }
    }

}
