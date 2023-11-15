package christmas.service;

import christmas.constants.DiscountType;
import christmas.domain.DiscountItem;
import christmas.domain.DiscountItemsResult;
import christmas.domain.OrderItemsResult;
import christmas.utils.SpecialDayIdentifier;
import christmas.utils.WeekdayWeekendIdentifier;
import java.util.List;

public class DiscountService {
    private final int date;

    private final OrderItemsResult orderItemsResult;

    private DiscountService(OrderItemsResult orderItemsResult, int date) {
        this.orderItemsResult = orderItemsResult;
        this.date = date;
    }

    public static DiscountService orderItemsResultDateOf(OrderItemsResult orderItemsResult, int date) {
        return new DiscountService(orderItemsResult, date);
    }

    public DiscountItemsResult execute() {
        List<DiscountItem> discountItems = List.of(
                discountXmas(),
                disCountWeek(),
                discountSpecial()
        );
        return DiscountItemsResult.discountItemsOf(discountItems);
    }

    public DiscountItem discountXmas() {
        if (date < 26) {
            DiscountType type = DiscountType.XMAS_D_DAY_DISCOUNT;
            int salesPrice = 1000 + (date * 100);
            return DiscountItem.discountTypeDiscountPriceOf(type, salesPrice);
        }
        return DiscountItem.discountTypeDiscountPriceOf(DiscountType.NO_DISCOUNT, 0);
    }

    public DiscountItem disCountWeek() {
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

    public DiscountItem discountSpecial() {
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
