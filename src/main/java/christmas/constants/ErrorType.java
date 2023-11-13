package christmas.constants;

public enum ErrorType {

    CAN_NOT_CONVERT_INTEGER("[ERROR] INTEGER로 변환할 수 없습니다."),

    DATE_RANGE_IS_NOT_VALIDATE("[ERROR] 1 ~ 31까지의 날짜만 입력할 수 있습니다"),

    CAN_NOT_FOUND_MENU("[ERROR] 입력하신 메뉴를 찾을 수 없습니다");




    private final String errorMessage;

    ErrorType(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
