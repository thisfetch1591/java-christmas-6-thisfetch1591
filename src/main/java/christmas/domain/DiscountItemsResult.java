package christmas.domain;

import java.util.List;

public class DiscountItemsResult {
    private final List<DiscountItem> discountItems;

    private DiscountItemsResult(List<DiscountItem> discountItems) {
        this.discountItems = discountItems;
    }

    public static DiscountItemsResult discountItemsOf(List<DiscountItem> discountItems) {
        return new DiscountItemsResult(discountItems);
    }

    public int getTotalDiscountPrice() {
        int totalPrice = 0;
        for (DiscountItem item : discountItems) {
            totalPrice = item.addDiscountPrice(totalPrice);
        }
        return totalPrice;
    }

}
