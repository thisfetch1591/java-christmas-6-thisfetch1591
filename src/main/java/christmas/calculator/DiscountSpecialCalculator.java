package christmas.calculator;

import christmas.constants.DiscountType;
import christmas.domain.DiscountItem;
import christmas.utils.SpecialDayIdentifier;

public class DiscountSpecialCalculator {

    private final static int BASIC_DISCOUNT_PRICE = 1000;

    private final static int MIN_TOTAL_PRICE = 10000;
    private final int date;


    private DiscountSpecialCalculator(int date) {
        this.date = date;
    }

    public static DiscountSpecialCalculator of(int date) {
        return new DiscountSpecialCalculator(date);
    }

    public DiscountItem execute(int totalPrice) {
        SpecialDayIdentifier identifier = SpecialDayIdentifier.of(date);
        boolean isSpecial = identifier.isSpecialDay();
        if (isSpecial && totalPrice >= MIN_TOTAL_PRICE) {
            DiscountType type = DiscountType.SPECIAL_DISCOUNT;
            int salesPrice = BASIC_DISCOUNT_PRICE;
            return DiscountItem.discountTypeDiscountPriceOf(type, salesPrice);
        }
        return DiscountItem.discountTypeDiscountPriceOf(DiscountType.NO_DISCOUNT, 0);
    }
}
