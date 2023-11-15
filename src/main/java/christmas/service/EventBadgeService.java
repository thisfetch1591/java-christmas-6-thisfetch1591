package christmas.service;

public class EventBadgeService {
    private final int totalDiscountPrice;

    private EventBadgeService(int totalDiscountPrice) {
        this.totalDiscountPrice = totalDiscountPrice;
    }

    public static EventBadgeService of(int totalDiscountPrice) {
        return new EventBadgeService(totalDiscountPrice);
    }

    public String execute() {
        if (totalDiscountPrice >= 20000) {
            return "산타";
        }
        if (totalDiscountPrice >= 10000) {
            return "트리";
        }
        if (totalDiscountPrice >= 5000) {
            return "별";
        }
        return "없음";
    }
}
