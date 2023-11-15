package christmas.controller;

import static christmas.view.OutputView.*;
import static christmas.view.InputView.*;

import christmas.domain.DiscountItemsResult;
import christmas.domain.OrderItemsResult;
import christmas.service.DiscountService;
import christmas.service.EventBadgeService;
import christmas.service.FreeGiftService;
import christmas.utils.PriceFormatter;

public class Calender {
    private int date;
    private boolean isDiscount = false;
    private OrderItemsResult orderItemsResult;
    private DiscountItemsResult discountItemsResult;
    private String totalBeforeDiscountPrice;
    private String freeGiftSentence;
    private String totalDiscountResultSentence;
    private String totalDiscountPrice;
    private String totalExpectPrice;
    private String eventBadge;

    public void start() {
        init();
        progress();
        result();
    }

    private void init() {
        printWelcome();
        judgeReEnterDateValue();
        judgeReEnterOrderValue();
        printPreViewInform(date);
        if (orderItemsResult.getTotalPrices() >= 10000) {
            isDiscount = true;
        }
    }

    private void progress() {
        getTotalPreDiscountPrice();
        DiscountService discountService = setDiscountService();
        getTotalExpectPrice();
        getFreeGift(discountService);
        getTotalDiscountResult(discountService);
        getTotalDiscountPrice();
        getEventBadge();
    }

    private void result() {
        printOrderMenu(orderItemsResult.getOrderMenuResultSentence());
        printPreDiscountPrice(totalBeforeDiscountPrice);
        printFreeGift(freeGiftSentence);
        printDiscountContext(isDiscount, totalDiscountResultSentence);
        printDiscountPrice(totalDiscountPrice);
        printExpectPaymentPrice(totalExpectPrice);
        printEventBadge(eventBadge);
    }

    private void judgeReEnterDateValue() {
        while (true) {
            try {
                date = readDate();
                break;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private void judgeReEnterOrderValue() {
        while (true) {
            try {
                orderItemsResult = readOrder();
                break;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private void getEventBadge() {
        EventBadgeService eventBadgeService = EventBadgeService.of(discountItemsResult.getTotalDiscountPrice());
        eventBadge = eventBadgeService.execute();
    }

    private void getTotalDiscountPrice() {
        totalDiscountPrice = PriceFormatter.formatPrice(discountItemsResult.getTotalDiscountPrice());
    }

    private void getTotalDiscountResult(DiscountService discountService) {
        totalDiscountResultSentence = discountService.execute().getDiscountItemsResultSentence();
    }

    private void getTotalExpectPrice() {
        totalExpectPrice = PriceFormatter.formatPrice(
                orderItemsResult.getTotalPrices() - discountItemsResult.getTotalDiscountPrice());
    }

    private DiscountService setDiscountService() {
        DiscountService discountService = DiscountService.orderItemsResultDateOf(orderItemsResult, date);
        discountItemsResult = discountService.execute();
        return discountService;
    }

    private void getTotalPreDiscountPrice() {
        totalBeforeDiscountPrice = PriceFormatter.formatPrice(orderItemsResult.getTotalPrices());
    }

    private void getFreeGift(DiscountService discountService) {
        FreeGiftService freeGiftService = FreeGiftService.of(orderItemsResult.getTotalPrices());
        FreeGiftService.addDiscountItem(discountItemsResult);
        freeGiftSentence = freeGiftService.execute().getOrderItemSentence();
        discountService.addFreeGiftToItemResult(discountItemsResult);
    }
}
