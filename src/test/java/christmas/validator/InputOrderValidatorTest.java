package christmas.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import christmas.constants.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputOrderValidatorTest {

    @DisplayName("메뉴에 특수기호가 들어갈 시 예외처리")
    @ValueSource(strings = {"시저샐러드=", "바베큐립."})
    @ParameterizedTest
    void createExceptionForContainsSpecialSymbol(String input) {
        assertThatThrownBy(() -> InputOrderValidator.validateExistMenuName(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("제공된 메뉴에 없는 메뉴를 입력 시 예외처리")
    @ValueSource(strings = {"마라탕", "마라샹궈"})
    @ParameterizedTest
    void createExceptionForNotExistMenuName(String input) {
        assertThatThrownBy(() -> InputOrderValidator.validateExistMenuName(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("제공된 메뉴를 입력 시 정상 작동")
    @ValueSource(strings = {"양송이수프", "해산물파스타", "제로콜라"})
    @ParameterizedTest
    void normalOperationInputCorrectValue(String input) {
        Menu menu = Menu.find(input);
        assertEquals(true, menu.isSameName(input));
    }
}