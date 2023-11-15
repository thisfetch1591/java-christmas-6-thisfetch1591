package christmas.service;

import static org.junit.jupiter.api.Assertions.*;

import christmas.constants.Menu;
import christmas.domain.DiscountItemsResult;
import christmas.domain.OrderItem;
import christmas.domain.OrderItemsResult;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FreeGiftServiceTest {

    @DisplayName("12만원을 넘지 않았을 시 NOT_EXIST_MENU를 받는다")
    @Test
    void responseNotExistMenuWhenNotOverSomePrice() {
        List<OrderItem> orderItems = List.of(
                OrderItem.itemQuantityOf(Menu.RED_WINE, 1),
                OrderItem.itemQuantityOf(Menu.CAESAR_SALAD, 1),
                OrderItem.itemQuantityOf(Menu.ZERO_COKE, 1)
        );
        OrderItemsResult orderItemsResult = OrderItemsResult.of(orderItems);
        OrderItem expectGiftItem = OrderItem.itemQuantityOf(Menu.NOT_EXIST_MENU, 1);
        FreeGiftService freeGiftService = FreeGiftService.of(orderItemsResult.getTotalPrices());
        OrderItem freeGiftItem = freeGiftService.execute();
        assertEquals(true, freeGiftItem.equals(expectGiftItem));
    }

    @DisplayName("12만원을 넘겼을 시 샴페인을 받는다")
    @Test
    void responseChampagneWhenOverSomePrice() {
        List<OrderItem> orderItems = List.of(
                OrderItem.itemQuantityOf(Menu.RED_WINE, 10),
                OrderItem.itemQuantityOf(Menu.CAESAR_SALAD, 1),
                OrderItem.itemQuantityOf(Menu.ZERO_COKE, 1)
        );
        OrderItemsResult orderItemsResult = OrderItemsResult.of(orderItems);
        OrderItem expectGiftItem = OrderItem.itemQuantityOf(Menu.CHAMPAGNE, 1);
        FreeGiftService freeGiftService = FreeGiftService.of(orderItemsResult.getTotalPrices());
        OrderItem freeGiftItem = freeGiftService.execute();
        assertEquals(true, freeGiftItem.equals(expectGiftItem));
    }

}