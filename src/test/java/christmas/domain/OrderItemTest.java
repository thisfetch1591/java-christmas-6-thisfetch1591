package christmas.domain;

import static org.junit.jupiter.api.Assertions.*;

import christmas.constants.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderItemTest {

    @DisplayName("제로콜라를 추가할 시 isDrink는 true가 되어야 한다.")
    @Test
    void normalOperationWhenAddZeroCoke() {
        Menu item = Menu.ZERO_COKE;
        int quantity = 3;

        OrderItem orderItem = OrderItem.itemQuantityOf(item, quantity);
        boolean isDrink = orderItem.isDrink();

        assertEquals(true, isDrink);
    }

    @DisplayName("음식류를 주문할 시 isDrink는 false가 되어야 한다.")
    @Test
    void normalOperationWhenAddFood() {
        Menu item = Menu.BARBECUE_LIP;
        int quantity = 1;

        OrderItem orderItem = OrderItem.itemQuantityOf(item, quantity);
        boolean isDrink = orderItem.isDrink();

        assertEquals(false, isDrink);
    }

    @DisplayName("여러 수량을 입력 시 합한 수량을 출력할 수 있다.")
    @Test
    void normalOperationWhenCorrectQuantity() {
        Menu item1 = Menu.BARBECUE_LIP;
        int quantity1 = 1;
        OrderItem orderItem1 = OrderItem.itemQuantityOf(item1, quantity1);
        Menu item2 = Menu.CAESAR_SALAD;
        int quantity2 = 2;
        OrderItem orderItem2 = OrderItem.itemQuantityOf(item2, quantity2);

        int totalQuantity = orderItem1.addQuantity(0);
        totalQuantity = orderItem2.addQuantity(totalQuantity);

        assertEquals(totalQuantity, 3);
    }
}