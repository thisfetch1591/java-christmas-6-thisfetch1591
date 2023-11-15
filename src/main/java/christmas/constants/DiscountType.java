package christmas.constants;

import static christmas.constants.ErrorType.CAN_NOT_FOUND_MENU;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum DiscountType {
    NO_DISCOUNT("할인 해당 없음", 0),
    XMAS_D_DAY_DISCOUNT("크리스마스 디데이 할인", 1),
    WEEKDAY_DISCOUNT("평일 할인", 2),
    WEEKEND_DISCOUNT("주말 할인", 3),
    SPECIAL_DISCOUNT("특별 할인", 3),
    FREE_GIFT_EVENT("증정 이벤트", 4);

    private String discountContext;
    private int discountCode;

    private DiscountType(String discountContext, int discountCode) {
        this.discountContext = discountContext;
        this.discountCode = discountCode;
    }

    public String getDiscountContext() {
        return discountContext;
    }
}
