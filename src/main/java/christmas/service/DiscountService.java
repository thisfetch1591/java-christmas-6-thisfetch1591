package christmas.service;

import christmas.domain.OrderItemsResult;
import christmas.utils.SpecialDayIdentifier;
import christmas.utils.WeekdayWeekendIdentifier;

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

    public int discountXmas() {
        if (date < 26) {
            return 1000 + (date * 100);
        }
        return 0;
    }

    public int disCountWeek() {
        WeekdayWeekendIdentifier identifier = WeekdayWeekendIdentifier.of(date);
        boolean isWeekend = identifier.isWeekend();
        if (isWeekend) {
            return orderItemsResult.getMainMenuDiscountPrice();
        }
        return orderItemsResult.getDessertDiscountPrice();
    }

    public int discountSpecial() {
        SpecialDayIdentifier identifier = SpecialDayIdentifier.of(date);
        boolean isSpecial = identifier.isSpecialDay();
        if (isSpecial) {
            return 1000;
        }
        return 0;
    }
}
