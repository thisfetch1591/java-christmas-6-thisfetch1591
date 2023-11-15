package christmas.view;

import christmas.domain.OrderItem;
import christmas.domain.OrderItemsResult;
import christmas.service.FreeGiftService;

public class OutputView {

    public static void printWelcome() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플레너입니다.");
    }

    public static void printPreViewInform(int date) {
        System.out.println("12월 " + date + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
    }

    public static void printRequestInputDate() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");;
    }

    public static void printRequestInputOrder() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
    }

    public static void printOrderMenu(String orderMenuResult) {
        System.out.println("<주문 메뉴>");
        System.out.println(orderMenuResult);
    }

    public static void printPreDiscountPrice(String totalPrice) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(totalPrice + "원");
    }

    public static void printFreeGift(String orderItemSentence) {
        System.out.println("<증정 메뉴>");
        if (orderItemSentence.contains("없음")) {
            System.out.println("없음");
            return;
        }
        System.out.println(orderItemSentence);
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
        if (discountPrice == "0") {
            System.out.println("0원");
            return;
        }
        System.out.println( "-"+ discountPrice + "원");
    }

    public static void printExpectPaymentPrice(String paymentPrice) {
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(paymentPrice + "원");
    }

    public static void printEventBadge(String eventBadge) {
        System.out.println("<12월 이벤트 배지>");
        System.out.println(eventBadge);
    }

}
