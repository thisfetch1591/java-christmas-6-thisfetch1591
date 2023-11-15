package christmas.service;

import christmas.domain.DiscountItem;
import christmas.domain.DiscountItemsResult;
import christmas.domain.OrderItemsResult;
import christmas.utils.DiscountSpecialCalculator;
import christmas.utils.DiscountWeekCalculator;
import christmas.utils.DiscountXmasCalculator;
import java.util.List;

public class DiscountService {

    private final static int GIFT_MIN_PRICE = 120000;
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
        DiscountXmasCalculator discountXmasCalculator = DiscountXmasCalculator.of(date);
        DiscountSpecialCalculator discountSpecialCalculator = DiscountSpecialCalculator.of(date);
        DiscountWeekCalculator discountWeekCalculator = DiscountWeekCalculator.of(date);
        List<DiscountItem> discountItems = List.of(
                discountXmasCalculator.execute(),
                discountWeekCalculator.execute(orderItemsResult),
                discountSpecialCalculator.execute()
        );
        DiscountItemsResult results = DiscountItemsResult.discountItemsOf(discountItems);
        if (orderItemsResult.getTotalPrices() == GIFT_MIN_PRICE) {
            FreeGiftService.addDiscountItem(results);
        }
        return results;
    }
}
