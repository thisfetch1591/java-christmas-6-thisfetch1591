package christmas.calculator;

import christmas.constants.DiscountType;
import christmas.domain.DiscountItem;

public class DiscountXmasCalculator {
    private final static int CHRISTMAS_END_DATE = 26;

    private final static int START_DISCOUNT_PRICE = 1000;
    private final static int INCREASE_DISCOUNT_PRICE = 100;

    private final static int MIN_TOTAL_PRICE = 10000;

    private final int date;

    private DiscountXmasCalculator(int date) {
        this.date = date;
    }

    public static DiscountXmasCalculator of(int date) {
        return new DiscountXmasCalculator(date);
    }

    public DiscountItem execute(int totalPrice) {
        if (date < CHRISTMAS_END_DATE && totalPrice >= MIN_TOTAL_PRICE) {
            DiscountType type = DiscountType.XMAS_D_DAY_DISCOUNT;
            int salesPrice = (START_DISCOUNT_PRICE + ((date - 1) * INCREASE_DISCOUNT_PRICE));
            return DiscountItem.discountTypeDiscountPriceOf(type, salesPrice);
        }
        return DiscountItem.discountTypeDiscountPriceOf(DiscountType.NO_DISCOUNT, 0);
    }
}
