package christmas.utils;

import static org.junit.jupiter.api.Assertions.*;

import christmas.constants.DiscountType;
import christmas.domain.DiscountItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DiscountXmasCalculatorTest {

    @DisplayName("30일을 입력 시 이벤트 미적용")
    @Test
    void normalOperationWhenInputNotEventDay() {
        int date = 30;
        DiscountXmasCalculator discountXmasCalculator = DiscountXmasCalculator.of(date);
        DiscountItem discountItem = discountXmasCalculator.execute();
        DiscountItem expectDiscountItem = DiscountItem.discountTypeDiscountPriceOf(DiscountType.NO_DISCOUNT, 0);
        boolean isNotDiscount = discountItem.equals(expectDiscountItem);
        assertTrue(isNotDiscount);
    }

    @DisplayName("25일을 입력 시 3400원 할인")
    @Test
    void normalOperationWhenInputEventDay() {
        int date = 25;
        DiscountXmasCalculator discountXmasCalculator = DiscountXmasCalculator.of(date);
        DiscountItem discountItem = discountXmasCalculator.execute();
        DiscountItem expectDiscountItem = DiscountItem.discountTypeDiscountPriceOf(DiscountType.XMAS_D_DAY_DISCOUNT,
                3400);
        boolean isDiscount = discountItem.equals(expectDiscountItem);
        assertTrue(isDiscount);
    }

}