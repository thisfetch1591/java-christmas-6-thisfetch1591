package christmas.calculator;

import christmas.constants.DiscountType;
import christmas.domain.DiscountItem;
import christmas.domain.OrderItemsResult;
import christmas.utils.WeekdayWeekendIdentifier;

public class DiscountWeekCalculator {

    private final static int MIN_TOTAL_PRICE = 10000;
    private final int date;

    private DiscountWeekCalculator(int date) {
        this.date = date;
    }

    public static DiscountWeekCalculator of(int date) {
        return new DiscountWeekCalculator(date);
    }

    public DiscountItem execute(OrderItemsResult orderItemsResult) {
        if(orderItemsResult.getTotalPrices() < MIN_TOTAL_PRICE) {
            return DiscountItem.discountTypeDiscountPriceOf(DiscountType.NO_DISCOUNT, 0);
        }
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
