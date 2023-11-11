package christmas.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputDateValidatorTest {

    @DisplayName("Integer로 변환하지 못할 시 에러처리")
    @Test
    void createExceptionForNotInteger() {
        String input = "삼십일일";
        assertThatThrownBy(() -> InputDateValidator.validateDate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("32를 입력 시 예외처리")
    @Test
    void createExceptionForNotExistOverDate() {
        String input = "32";
        assertThatThrownBy(() -> InputDateValidator.validateDate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("0을 입력 시 예외처리")
    @Test
    void createExceptionForNotExistUnderDate() {
        String input = "0";
        assertThatThrownBy(() -> InputDateValidator.validateDate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("제대로 된 숫자를 입력 시 함수의 정상 작동")
    @Test
    void create() {
        String input = "10";
        assertEquals(10, InputDateValidator.validateDate(input));
    }
}