package christmas.service;

import christmas.domain.DiscountItem;
import christmas.domain.DiscountItemsResult;
import christmas.domain.OrderItemsResult;
import christmas.calculator.DiscountSpecialCalculator;
import christmas.calculator.DiscountWeekCalculator;
import christmas.calculator.DiscountXmasCalculator;
import java.util.ArrayList;
import java.util.List;

public class DiscountService {

    private final static int MIN_TOTAL_PRICE_FOR_FREE_GIFT = 120000;
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
        List<DiscountItem> discountItems = new ArrayList<>(List.of(
                discountXmasCalculator.execute(),
                discountWeekCalculator.execute(orderItemsResult),
                discountSpecialCalculator.execute())
        );
        DiscountItemsResult results = DiscountItemsResult.discountItemsOf(discountItems);
        return results;
    }

    public void addFreeGiftToItemResult(DiscountItemsResult results) {
        if (orderItemsResult.getTotalPrices() >= MIN_TOTAL_PRICE_FOR_FREE_GIFT) {
            FreeGiftService.addDiscountItem(orderItemsResult.getTotalPrices(), results);
        }
    }
}
