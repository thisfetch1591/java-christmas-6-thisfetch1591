package christmas.utils;

import christmas.constants.DiscountType;
import christmas.domain.DiscountItem;

public class DiscountXmasCalculator {

    private final int date;

    private DiscountXmasCalculator(int date) {
        this.date = date;
    }

    public static DiscountXmasCalculator of(int date) {
        return new DiscountXmasCalculator(date);
    }

    public DiscountItem execute() {
        if (date < 26) {
            DiscountType type = DiscountType.XMAS_D_DAY_DISCOUNT;
            int salesPrice = (1000 + ((date - 1) * 100));
            return DiscountItem.discountTypeDiscountPriceOf(type, salesPrice);
        }
        return DiscountItem.discountTypeDiscountPriceOf(DiscountType.NO_DISCOUNT, 0);
    }
}
