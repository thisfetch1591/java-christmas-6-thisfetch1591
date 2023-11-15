package christmas.view;

import christmas.domain.OrderItem;
import christmas.domain.OrderItemsResult;
import christmas.service.FreeGiftService;

public class OutputView {

    public static void printWelcome() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플레너입니다.");
    }

    public static void printOrderMenu(String orderMenuResult) {
        System.out.println("<주문 메뉴>");
        System.out.println(orderMenuResult);
    }

    public static void printPreDiscountPrice(int totalPrice) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(totalPrice + "원");
    }

    public static void printFreeGift(OrderItem orderItem) {
        System.out.println("<증정 메뉴>");
        if (orderItem.isNotExistMenu()) {
            System.out.println("없음");
            return;
        }
        System.out.println(orderItem.getOrderItemSentence());
    }

    public static void printDiscountContext(boolean isDiscount, String discountContext) {
        System.out.println("<혜택 내역>");
        if (isDiscount) {
            System.out.println(discountContext);
            return;
        }
        System.out.println("없음");
    }

    public static void printDiscountPrice(String discountPrice) {
        System.out.println("<총혜택 금액>");
        System.out.println(discountPrice);
    }

    public static void printExpectPaymentPrice(String paymentPrice) {
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(paymentPrice);
    }

    public static void printEventBadge(String eventBadge) {
        System.out.println("<12월 이벤트 배지>");
        System.out.println(eventBadge);
    }

}
