package christmas.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WeekdayWeekendIdentifierTest {

    @DisplayName("1,2,8,9,15,16,22,23,29,30일을 입력 시 주말 판정")
    @ValueSource(ints = {1, 2, 8, 9, 15, 16, 22, 23, 29, 30})
    @ParameterizedTest
    void getWeekendDayWhenInputSomeDay(int inputDate) {
        WeekdayWeekendIdentifier weekdayWeekendIdentifier = WeekdayWeekendIdentifier.of(inputDate);

        assertEquals(true, weekdayWeekendIdentifier.isWeekend());
    }

    @DisplayName("주말을 제외한 임의의 일을 입력 시 주말 판정")
    @ValueSource(ints = {3, 4, 6, 7, 14, 13, 21, 20, 26, 27})
    @ParameterizedTest
    void getWeekDayWhenInputSomeDay(int inputDate) {
        WeekdayWeekendIdentifier weekdayWeekendIdentifier = WeekdayWeekendIdentifier.of(inputDate);

        assertEquals(false, weekdayWeekendIdentifier.isWeekend());
    }
}