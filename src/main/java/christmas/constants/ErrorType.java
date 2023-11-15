package christmas.constants;

public enum ErrorType {

    CAN_NOT_CONVERT_DATE_TO_INTEGER("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),

    DATE_RANGE_IS_NOT_VALIDATE("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),

    CAN_NOT_FOUND_MENU("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    CAN_NOT_ORDER_NUMBER("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),

    CAN_NOT_CONVERT_QUANTITY_TO_INTEGER("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");

    private final String errorMessage;

    ErrorType(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
