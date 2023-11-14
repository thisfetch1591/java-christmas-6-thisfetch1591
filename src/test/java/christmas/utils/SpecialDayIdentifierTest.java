package christmas.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class SpecialDayIdentifierTest {

    @DisplayName("3,10,17,24,25,31일을 입력 시 스페셜데이 판정")
    @ValueSource(ints = {3, 10, 17, 24, 25, 31})
    @ParameterizedTest
    void getSpecialDayWhenInputSomeDay(int inputDate) {
        SpecialDayIdentifier specialDayIdentifier = SpecialDayIdentifier.of(inputDate);

        assertEquals(true, specialDayIdentifier.isSpecialDay());
    }

    @DisplayName("이외의 날을 입력 시 스페셜데이가 아님을 판정")
    @ValueSource(ints = {1, 4, 15, 18, 29, 30})
    @ParameterizedTest
    void getNotSpecialDayWhenInputSomeDay(int inputDate) {
        SpecialDayIdentifier specialDayIdentifier = SpecialDayIdentifier.of(inputDate);

        assertEquals(false, specialDayIdentifier.isSpecialDay());
    }
}