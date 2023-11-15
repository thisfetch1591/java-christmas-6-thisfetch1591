package christmas.view;

import static christmas.utils.StringParser.*;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.OrderItemsResult;

public class InputView {
    public static int readDate() {
        String input = Console.readLine();
        return parseDateInput(input);
    }

    public static OrderItemsResult readOrder() {
        String input = Console.readLine();
        Console.close();
        return parseOrderInput(input);
    }
}
