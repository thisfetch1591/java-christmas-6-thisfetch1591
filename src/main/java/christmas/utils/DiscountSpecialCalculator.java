package christmas.utils;

import christmas.constants.DiscountType;
import christmas.domain.DiscountItem;

public class DiscountSpecialCalculator {

    private final int date;

    private DiscountSpecialCalculator(int date) {
        this.date = date;
    }

    public static DiscountSpecialCalculator of(int date) {
        return new DiscountSpecialCalculator(date);
    }

    public DiscountItem execute() {
        SpecialDayIdentifier identifier = SpecialDayIdentifier.of(date);
        boolean isSpecial = identifier.isSpecialDay();
        if (isSpecial) {
            DiscountType type = DiscountType.SPECIAL_DISCOUNT;
            int salesPrice = 1000;
            return DiscountItem.discountTypeDiscountPriceOf(type, salesPrice);
        }
        return DiscountItem.discountTypeDiscountPriceOf(DiscountType.NO_DISCOUNT, 0);
    }
}
