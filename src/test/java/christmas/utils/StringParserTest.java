package christmas.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import christmas.domain.OrderItem;
import christmas.domain.OrderItemsResult;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StringParserTest {

    @DisplayName("잘못된 메뉴 이름을 입력 시 에러 처리")
    @Test
    void createExceptionForWrongMenuName() {
        String input = "티본 스테이키 - 1 , 바베큐립 - 2 , 제로코크 - 1";
        assertThatThrownBy(() -> StringParser.parseOrderInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("잘못된 수량 타입을 입력 시 에러 처리")
    @Test
    void createExceptionForWrongQuantity() {
        String input = "티본 스테이크 - 하나 , 바베큐립 - 둘 , 제로콜라 - 하나";
        assertThatThrownBy(() -> StringParser.parseOrderInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("공백을 넣어도 정상적으로 입력 처리")
    @Test
    void normalOperationWhenInputContainsWhiteSpace() {
        String input = "티본 스테이크 - 1 , 바베큐립 - 2 , 제로콜라 - 1";
        OrderItemsResult orderItems= StringParser.parseOrderInput(input);
    }

    @DisplayName("정상적으로 입력 처리")
    @Test
    void normalOperationWhenCorrectOrderInput() {
        String input = "티본스테이크-1,바베큐립-2,제로콜라-1";
        OrderItemsResult orderItems= StringParser.parseOrderInput(input);
    }

    @DisplayName("잘못된 날짜 타입을 입력 시 에러 처리")
    @ValueSource(strings= {"이십오일", "1.0"})
    @ParameterizedTest
    void createExceptionForWrongDateType(String input) {
        assertThatThrownBy(() -> StringParser.parseDateInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정상적으로 입력 처리")
    @Test
    void normalOperationWhenCorrectDateInput() {
        String input = "24";
        int date = StringParser.parseDateInput(input);

        assertEquals(24, date);
    }
}