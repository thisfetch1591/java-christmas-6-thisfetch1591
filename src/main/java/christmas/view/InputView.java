package christmas.view;

import camp.nextstep.edu.missionutils.Console;

import static christmas.validator.InputDateValidator.validateDate;

public class InputView {
    public static int readDate() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        String input = Console.readLine();
        return validateDate(input);
    }
}
