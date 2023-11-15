package christmas.service;

import christmas.constants.DiscountType;
import christmas.constants.Menu;
import christmas.domain.DiscountItem;
import christmas.domain.DiscountItemsResult;
import christmas.domain.OrderItem;

public class FreeGiftService {

    private final static int GIFT_MIN_PRICE = 120000;

    private final static int GIFT_QUANTITY = 1;

    private final static Menu FREE_GIFT_MENU = Menu.CHAMPAGNE;

    private final static Menu AVOID_GIFT_MENU = Menu.NOT_EXIST_MENU;

    private final int totalPrice;

    private FreeGiftService(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public static FreeGiftService of(int totalPrice) {
        return new FreeGiftService(totalPrice);
    }

    public OrderItem execute() {
        if (totalPrice >= GIFT_MIN_PRICE) {
            Menu giftMenu = FREE_GIFT_MENU;
            int giftQuantity = GIFT_QUANTITY;
            return OrderItem.itemQuantityOf(giftMenu, giftQuantity);
        }
        return OrderItem.itemQuantityOf(AVOID_GIFT_MENU, 1);
    }

    public static void addDiscountItem(int totalPrice, DiscountItemsResult discountItemsResult) {
        if (totalPrice >= GIFT_MIN_PRICE) {
            DiscountItem discountItem = DiscountItem.discountTypeDiscountPriceOf(DiscountType.FREE_GIFT_EVENT,
                    FREE_GIFT_MENU.getCostOfMenu());
            discountItemsResult.addDiscountItem(discountItem);
        }
    }
}
