package christmas.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputDateValidatorTest {

    @DisplayName("Integer로 변환하지 못할 시 에러처리")
    @ValueSource(strings = {"삼십일일"})
    @ParameterizedTest
    void createExceptionForNotInteger(String input) {
        assertThatThrownBy(() -> InputDateValidator.validateDate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1~31에 해당하지 않은 숫자를 입력 시 예외처리")
    @ValueSource(strings = {"32", "0", "-25"})
    @ParameterizedTest
    void createExceptionForNotExistOverDate(String input) {
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