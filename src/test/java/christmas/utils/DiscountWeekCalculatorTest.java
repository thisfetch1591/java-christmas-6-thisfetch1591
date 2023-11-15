package christmas.utils;

import static org.junit.jupiter.api.Assertions.*;

import christmas.calculator.DiscountWeekCalculator;
import christmas.constants.DiscountType;
import christmas.constants.Menu;
import christmas.domain.DiscountItem;
import christmas.domain.OrderItem;
import christmas.domain.OrderItemsResult;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DiscountWeekCalculatorTest {

    @DisplayName("평일일 경우 4046원 할인")
    @Test
    void normalOperationWhenInputWeekday() {
        int date = 7;
        List<OrderItem> orderItems = List.of(
                OrderItem.itemQuantityOf(Menu.RED_WINE, 1),
                OrderItem.itemQuantityOf(Menu.CAESAR_SALAD, 1),
                OrderItem.itemQuantityOf(Menu.ZERO_COKE, 1)
        );
        OrderItemsResult orderItemsResult = OrderItemsResult.of(orderItems);
        DiscountWeekCalculator discountWeekCalculator = DiscountWeekCalculator.of(date);
        DiscountItem expectDiscountItem = DiscountItem.discountTypeDiscountPriceOf(DiscountType.WEEKDAY_DISCOUNT, 4046);
        DiscountItem discountItem = discountWeekCalculator.execute(orderItemsResult);
        boolean isDiscount = discountItem.equals(expectDiscountItem);
        assertTrue(isDiscount);
    }

    @DisplayName("주말일 경우 2023원 할인")
    @Test
    void normalOperationWhenInputWeekend() {
        int date = 8;
        List<OrderItem> orderItems = List.of(
                OrderItem.itemQuantityOf(Menu.RED_WINE, 1),
                OrderItem.itemQuantityOf(Menu.CAESAR_SALAD, 1),
                OrderItem.itemQuantityOf(Menu.ZERO_COKE, 1)
        );
        OrderItemsResult orderItemsResult = OrderItemsResult.of(orderItems);
        DiscountWeekCalculator discountWeekCalculator = DiscountWeekCalculator.of(date);
        DiscountItem expectDiscountItem = DiscountItem.discountTypeDiscountPriceOf(DiscountType.WEEKEND_DISCOUNT, 2023);
        DiscountItem discountItem = discountWeekCalculator.execute(orderItemsResult);
        boolean isDiscount = discountItem.equals(expectDiscountItem);
        assertTrue(isDiscount);
    }

}