package christmas.domain;

import java.util.List;

public class OrderItemsResult {
    private static final int DISCOUNT_PRICE = 2023;
    private final List<OrderItem> orderItems;

    private OrderItemsResult(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
        validateDuplicatedItem();
        validateOrderOnlyBeverage();
        validateMaxQuantityOrder();
    }

    public static OrderItemsResult of(List<OrderItem> orderItems) {
        return new OrderItemsResult(orderItems);
    }

    public int getTotalPrices() {
        int totalPrices = 0;
        for (OrderItem item : orderItems) {
            totalPrices = item.addPrices(totalPrices);
        }
        return totalPrices;
    }

    public int getDessertDiscountPrice() {
        int count = 0;
        for (OrderItem item : orderItems) {
            if (item.isDessert()) {
                count++;
            }
        }
        return DISCOUNT_PRICE * count;
    }

    public int getMainMenuDiscountPrice() {
        int count = 0;
        for (OrderItem item : orderItems) {
            if (item.isMainMenu()) {
                count++;
            }
        }
        return DISCOUNT_PRICE * count;
    }

    private void validateDuplicatedItem() {
        List<OrderItem> distinctOrderItems = orderItems.stream()
                .distinct()
                .toList();

        if (distinctOrderItems.size() != orderItems.size()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateOrderOnlyBeverage() {
        boolean isOrderedFood = false;
        for (OrderItem item : orderItems) {
            if (item.isDrink() == false) {
                isOrderedFood = true;
            }
        }
        if (isOrderedFood == false) {
            throw new IllegalArgumentException();
        }
    }

    private void validateMaxQuantityOrder() {
        int quantity = 0;
        for (OrderItem item : orderItems) {
            quantity = item.addQuantity(quantity);
        }
        if (quantity > 20) {
            throw new IllegalArgumentException();
        }
    }
}
