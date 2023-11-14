package christmas.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.constants.Menu;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderItemsResultTest {

    @DisplayName("중복된 아이템을 예외 처리")
    @Test
    void createExceptionForDuplicatedInputItem() {
        List<OrderItem> orderItems = List.of(
                OrderItem.itemQuantityOf(Menu.BARBECUE_LIP, 1),
                OrderItem.itemQuantityOf(Menu.BARBECUE_LIP, 2),
                OrderItem.itemQuantityOf(Menu.ZERO_COKE, 3)
        );

        assertThatThrownBy(() -> OrderItemsResult.of(orderItems))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("음료만 입력 시 예외 처리")
    @Test
    void createExceptionForOrderedOnlyBeverage() {
        List<OrderItem> orderItems = List.of(
                OrderItem.itemQuantityOf(Menu.RED_WINE, 1),
                OrderItem.itemQuantityOf(Menu.CHAMPAGNE, 2),
                OrderItem.itemQuantityOf(Menu.ZERO_COKE, 3)
        );

        assertThatThrownBy(() -> OrderItemsResult.of(orderItems))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("음료만 입력 시 예외 처리")
    @Test
    void createExceptionForOrderedOverQuantity() {
        List<OrderItem> orderItems = List.of(
                OrderItem.itemQuantityOf(Menu.RED_WINE, 10),
                OrderItem.itemQuantityOf(Menu.CAESAR_SALAD, 9),
                OrderItem.itemQuantityOf(Menu.ZERO_COKE, 2)
        );

        assertThatThrownBy(() -> OrderItemsResult.of(orderItems))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정상적으로 입력 시 정상적으로 수행")
    @Test
    void normalOperationWhenCorrectOrdered() {
        List<OrderItem> orderItems = List.of(
                OrderItem.itemQuantityOf(Menu.RED_WINE, 5),
                OrderItem.itemQuantityOf(Menu.CAESAR_SALAD, 9),
                OrderItem.itemQuantityOf(Menu.ZERO_COKE, 2)
        );

        OrderItemsResult orderItemsResult = OrderItemsResult.of(orderItems);
    }
}