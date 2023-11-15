package christmas.utils;

import static org.junit.jupiter.api.Assertions.*;

import christmas.calculator.DiscountSpecialCalculator;
import christmas.constants.DiscountType;
import christmas.domain.DiscountItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DiscountSpecialCalculatorTest {

    @DisplayName("1일을 입력 시 이벤트 미적용")
    @Test
    void normalOperationWhenInputNotSpecialDay() {
        int date = 1;
        DiscountSpecialCalculator discountSpecialCalculator = DiscountSpecialCalculator.of(date);
        DiscountItem discountItem = discountSpecialCalculator.execute();
        DiscountItem expectDiscountItem = DiscountItem.discountTypeDiscountPriceOf(DiscountType.SPECIAL_DISCOUNT, 1000);
        boolean isDiscount = discountItem.equals(expectDiscountItem);
        assertFalse(isDiscount);
    }

    @DisplayName("24일을 입력 시 이벤트 적용")
    @Test
    void normalOperationWhenInputSpecialDay() {
        int date = 24;
        DiscountSpecialCalculator discountSpecialCalculator = DiscountSpecialCalculator.of(date);
        DiscountItem discountItem = discountSpecialCalculator.execute();
        DiscountItem expectDiscountItem = DiscountItem.discountTypeDiscountPriceOf(DiscountType.SPECIAL_DISCOUNT, 1000);
        boolean isDiscount = discountItem.equals(expectDiscountItem);
        assertTrue(isDiscount);
    }

}