package christmas.utils;

import christmas.constants.DiscountType;
import christmas.domain.DiscountItem;
import christmas.domain.OrderItemsResult;

public class DiscountWeekCalculator {
    private final int date;

    private DiscountWeekCalculator(int date) {
        this.date = date;
    }

    public static DiscountWeekCalculator of(int date) {
        return new DiscountWeekCalculator(date);
    }

    public DiscountItem execute(OrderItemsResult orderItemsResult) {
        WeekdayWeekendIdentifier identifier = WeekdayWeekendIdentifier.of(date);
        boolean isWeekend = identifier.isWeekend();
        if (isWeekend) {
            DiscountType type = DiscountType.WEEKEND_DISCOUNT;
            int salesPrice = orderItemsResult.getMainMenuDiscountPrice();
            return DiscountItem.discountTypeDiscountPriceOf(type, salesPrice);
        }
        DiscountType type = DiscountType.WEEKDAY_DISCOUNT;
        int salesPrice = orderItemsResult.getDessertDiscountPrice();
        return DiscountItem.discountTypeDiscountPriceOf(type, salesPrice);
    }
}
