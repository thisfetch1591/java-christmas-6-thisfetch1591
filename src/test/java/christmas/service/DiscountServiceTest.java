package christmas.service;

import static org.junit.jupiter.api.Assertions.*;

import christmas.constants.Menu;
import christmas.domain.DiscountItemsResult;
import christmas.domain.OrderItem;
import christmas.domain.OrderItemsResult;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DiscountServiceTest {

    OrderItemsResult result;

    @BeforeEach
    void init() {
        List<OrderItem> orderItems = List.of(
                OrderItem.itemQuantityOf(Menu.RED_WINE, 10),
                OrderItem.itemQuantityOf(Menu.CAESAR_SALAD, 1),
                OrderItem.itemQuantityOf(Menu.ZERO_COKE, 1)
        );
        result = OrderItemsResult.of(orderItems);
    }

    @DisplayName("26일이 넘어갈 시 크리스마스 디데이 할인은 포함하지 않는다")
    @Test
    void notIncludeXMasDiscountWhenOver26() {
        int date = 26;
        DiscountService discountService = DiscountService.orderItemsResultDateOf(result, date);
        DiscountItemsResult result = discountService.execute();
        boolean isContain = result.getDiscountItemsResultSentence().contains("크리스마스 디데이 할인");
        assertFalse(isContain);
    }

    @DisplayName("평일일 시 평일 할인은 포함, 주말 할인은 포함하지 않는다")
    @Test
    void notIncludeWeekDayDiscountWhenOver26() {
        int date = 4;
        DiscountService discountService = DiscountService.orderItemsResultDateOf(result, date);
        DiscountItemsResult result = discountService.execute();
        boolean isContain1 = result.getDiscountItemsResultSentence().contains("주말 할인");
        boolean isContain2 = result.getDiscountItemsResultSentence().contains("평일 할인");
        assertFalse(isContain1);
        assertTrue(isContain2);
    }

    @DisplayName("주말일 시 주말 할인은 포함, 평일 할인은 포함하지 않는다")
    @Test
    void notIncludeWeekendDiscountWhenOver26() {
        int date = 2;
        DiscountService discountService = DiscountService.orderItemsResultDateOf(result, date);
        DiscountItemsResult result = discountService.execute();
        boolean isContain1 = result.getDiscountItemsResultSentence().contains("주말 할인");
        boolean isContain2 = result.getDiscountItemsResultSentence().contains("평일 할인");
        assertFalse(isContain2);
        assertTrue(isContain1);
    }

    @DisplayName("특정 일을 입력 시 특별 이벤트 입력")
    @Test
    void includeSpecialDayDiscountWhenOver26() {
        int date = 10;
        DiscountService discountService = DiscountService.orderItemsResultDateOf(result, date);
        DiscountItemsResult result = discountService.execute();
        boolean isContain1 = result.getDiscountItemsResultSentence().contains("특별 할인");
        assertTrue(isContain1);
    }

    @DisplayName("12만원 이상 시 증정 이벤트 세일 결과 객체에 포함")
    @Test
    void includeFreeGiftWhenOverPrice120000() {
        int date = 10;
        DiscountService discountService = DiscountService.orderItemsResultDateOf(result, date);
        DiscountItemsResult result = discountService.execute();
        boolean isContain1 = result.getDiscountItemsResultSentence().contains("증정 이벤트");
        assertTrue(isContain1);
    }
}