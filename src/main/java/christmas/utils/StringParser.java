package christmas.utils;

import static christmas.validator.InputDateValidator.validateRange;
import static christmas.validator.InputOrderValidator.validateExistMenuName;

import christmas.constants.Menu;
import christmas.domain.OrderItem;
import java.util.Arrays;
import java.util.List;

public class StringParser {

    public static List<OrderItem> parseOrderInput(String input) {
        input = removeWhiteSpace(input);
        List<String> items = parseInput(input);
        return addItemsToOrder(items);
    }

    public static int parseDateInput(String input) {
        input = removeWhiteSpace(input);
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

    private static String removeWhiteSpace(String input) {
        return input.replaceAll("\\s+", "");
    }

    private static List<String> parseInput(String input) {
        return Arrays.stream(input.split(","))
                .toList();
    }

    private static List<OrderItem> addItemsToOrder(List<String> items) {
        return items.stream().map(item -> {
            String[] split = item.split("-");
            Menu menu = validateExistMenuName(split[0]);
            int quantity = convertStringToInt(split[1]);
            return OrderItem.itemQuantityOf(menu, quantity);
        }).toList();
    }
}
