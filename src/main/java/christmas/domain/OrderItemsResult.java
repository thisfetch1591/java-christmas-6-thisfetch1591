package christmas.domain;

import static christmas.constants.ErrorType.CAN_NOT_FOUND_MENU;

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
                count += item.addQuantity(count);
            }
        }
        return DISCOUNT_PRICE * count;
    }

    public int getMainMenuDiscountPrice() {
        int count = 0;
        for (OrderItem item : orderItems) {
            if (item.isMainMenu()) {
                count += item.addQuantity(count);
            }
        }
        return DISCOUNT_PRICE * count;
    }

    public String getOrderMenuResultSentence() {
        StringBuilder sentence = new StringBuilder();
        for (OrderItem item : orderItems) {
            sentence.append(item.getOrderItemSentence());
        }
        return sentence.toString();
    }

    private void validateDuplicatedItem() {
        List<OrderItem> distinctOrderItems = orderItems.stream()
                .distinct()
                .toList();

        if (distinctOrderItems.size() != orderItems.size()) {
            throw new IllegalArgumentException(CAN_NOT_FOUND_MENU.getErrorMessage());
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
            throw new IllegalArgumentException(CAN_NOT_FOUND_MENU.getErrorMessage());
        }
    }

    private void validateMaxQuantityOrder() {
        int quantity = 0;
        for (OrderItem item : orderItems) {
            quantity = item.addQuantity(quantity);
        }
        if (quantity > 20) {
            throw new IllegalArgumentException(CAN_NOT_FOUND_MENU.getErrorMessage());
        }
    }
}
