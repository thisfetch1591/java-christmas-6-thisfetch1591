package christmas.utils;

import static christmas.constants.ErrorType.CAN_NOT_CONVERT_DATE_TO_INTEGER;
import static christmas.constants.ErrorType.CAN_NOT_CONVERT_QUANTITY_TO_INTEGER;
import static christmas.validator.InputDateValidator.validateRange;
import static christmas.validator.InputOrderValidator.validateExistMenuName;
import static christmas.validator.InputOrderValidator.validateRangeQuantity;

import christmas.constants.Menu;
import christmas.domain.OrderItem;
import christmas.domain.OrderItemsResult;
import java.util.Arrays;
import java.util.List;

public class StringParser {

    private final static String WHITE_SPACE_REGEX = "\\s+";
    private final static String SPLIT_INPUT_DELIMITER = ",";
    private final static String SPLIT_ORDER_DELIMITER = "-";
    private final static int MENU_NAME_INDEX = 0;
    private final static int QUANTITY_INDEX = 1;

    public static OrderItemsResult parseOrderInput(String input) {
        input = removeWhiteSpace(input);
        List<String> items = parseInput(input);
        List<OrderItem> orderItems = addItemsToOrder(items);

        return OrderItemsResult.of(orderItems);
    }

    public static int parseDateInput(String input) {
        input = removeWhiteSpace(input);
        int date = convertDateToInt(input);
        int validatedDate = validateRange(date);
        return validatedDate;
    }

    private static int convertDateToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(CAN_NOT_CONVERT_DATE_TO_INTEGER.getErrorMessage());
        }
    }

    private static int convertQuantityToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(CAN_NOT_CONVERT_QUANTITY_TO_INTEGER.getErrorMessage());
        }
    }

    private static String removeWhiteSpace(String input) {
        return input.replaceAll(WHITE_SPACE_REGEX, "");
    }

    private static List<String> parseInput(String input) {
        return Arrays.stream(input.split(SPLIT_INPUT_DELIMITER))
                .toList();
    }

    private static List<OrderItem> addItemsToOrder(List<String> items) {
        return items.stream().map(item -> {
            String[] split = item.split(SPLIT_ORDER_DELIMITER);
            Menu menu = validateExistMenuName(split[MENU_NAME_INDEX]);
            int quantity = convertQuantityToInt(split[QUANTITY_INDEX]);
            validateRangeQuantity(quantity);
            return OrderItem.itemQuantityOf(menu, quantity);
        }).toList();
    }

}
