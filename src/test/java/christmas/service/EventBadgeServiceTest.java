package christmas.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EventBadgeServiceTest {

    @DisplayName("총 세일 금액이 20000원을 넘어갈 시 산타 뱃지 증정")
    @Test
    void giveSantaBadgeWhenTotalPriceOver20000() {
        int price = 23220;
        EventBadgeService eventBadgeService = EventBadgeService.of(price);

        assertEquals("산타", eventBadgeService.execute());
    }

    @DisplayName("총 세일 금액이 10000원을 넘어갈 시 트리 뱃지 증정")
    @Test
    void giveSantaBadgeWhenTotalPriceOver10000() {
        int price = 17222;
        EventBadgeService eventBadgeService = EventBadgeService.of(price);

        assertEquals("트리", eventBadgeService.execute());
    }

    @DisplayName("총 세일 금액이 5000원을 넘어갈 시 별 뱃지 증정")
    @Test
    void giveSantaBadgeWhenTotalPriceOver5000() {
        int price = 5922;
        EventBadgeService eventBadgeService = EventBadgeService.of(price);

        assertEquals("별", eventBadgeService.execute());
    }

    @DisplayName("총 세일 금액이 5000원을 못 넘어갈 시 뱃지는 없다")
    @Test
    void giveSantaBadgeWhenTotalPriceUnder5000() {
        int price = 4092;
        EventBadgeService eventBadgeService = EventBadgeService.of(price);

        assertEquals("없음", eventBadgeService.execute());
    }

}