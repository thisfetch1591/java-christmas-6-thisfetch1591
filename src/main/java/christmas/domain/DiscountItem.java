package christmas.domain;

import christmas.constants.DiscountType;
import christmas.utils.PriceFormatter;
import java.text.DecimalFormat;
import java.util.Objects;

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

    public String getDiscountItemSentence() {
        String formattedPrice = PriceFormatter.formatPrice(discountPrice);
        return discountType.getDiscountContext() + ": -" + formattedPrice + "원\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DiscountItem other = (DiscountItem) obj;
        return this.discountType.name().equals(other.discountType.name());
    }

    @Override
    public int hashCode() {
        return Objects.hash(discountType.name());
    }
}
