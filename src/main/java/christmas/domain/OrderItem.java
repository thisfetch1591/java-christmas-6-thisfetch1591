package christmas.domain;

import christmas.constants.Menu;

public class OrderItem {
    private final Menu item;

    private final int quantity;

    private OrderItem(Menu item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public static OrderItem itemQuantityOf(Menu item, int quantity) {
        return new OrderItem(item, quantity);
    }
}
