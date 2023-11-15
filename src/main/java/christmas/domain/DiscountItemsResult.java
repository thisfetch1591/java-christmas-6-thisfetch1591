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

    public void addDiscountItem(DiscountItem discountItem) {
        discountItems.add(discountItem);
    }
    public int getTotalDiscountPrice() {
        int totalPrice = 0;
        for (DiscountItem item : discountItems) {
            totalPrice = item.addDiscountPrice(totalPrice);
        }
        return totalPrice;
    }

    public String getDiscountItemsResultSentence() {
        StringBuilder sentence = new StringBuilder();
        for (DiscountItem item : discountItems) {
            sentence.append(item.getDiscountItemSentence());
        }
        return sentence.toString();
    }
}
