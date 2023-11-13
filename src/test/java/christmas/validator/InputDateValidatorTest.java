package christmas.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputDateValidatorTest {

    @DisplayName("1~31에 해당하지 않은 숫자를 입력 시 예외처리")
    @ValueSource(ints = {32, 0, -25})
    @ParameterizedTest
    void createExceptionForNotExistOverUnderDate(int input) {
        assertThatThrownBy(() -> InputDateValidator.validateRange(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("올바른 값을 입력 시 정상 작동")
    @ValueSource(ints = {1, 31})
    @ParameterizedTest
    void normalOperationInputCorrectValue(int input) {
        int validatedValue = InputDateValidator.validateRange(input);
        assertEquals(input, validatedValue);
    }
}