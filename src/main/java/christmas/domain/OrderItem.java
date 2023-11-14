package christmas.domain;

import christmas.constants.Menu;
import java.util.Objects;

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

    public boolean isDrink() {
        if (item.isDrink()) {
            return true;
        }
        return false;
    }

    public int addQuantity(int quantity) {
        return quantity + this.quantity;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        OrderItem other = (OrderItem) obj;
        return this.item.name().equals(other.item.name());
    }

    @Override
    public int hashCode() {
        return Objects.hash(item.name());
    }
}
