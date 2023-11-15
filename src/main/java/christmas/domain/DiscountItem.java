package christmas.domain;

import christmas.constants.DiscountType;

public class DiscountItem {
    private final DiscountType discountType;
    private final int discountPrice;

    private DiscountItem(DiscountType discountType, int discountPrice) {
        this.discountType = discountType;
        this.discountPrice = discountPrice;
    }

    public static DiscountItem discountTypeDiscountPriceOf(DiscountType discountType, int discountPrice) {
        return new DiscountItem(discountType, discountPrice);
    }

    public int addDiscountPrice(int price) {
        return price + discountPrice;
    }
}
