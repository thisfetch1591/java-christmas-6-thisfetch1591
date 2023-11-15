package christmas.service;

public class EventBadgeService {

    private final static String SANTA_BADGE = "산타";
    private final static String TREE_BADGE = "트리";
    private final static String STAR_BADGE = "별";
    private final static String NO_BADGE = "없음";
    private final static int SANTA_PRICE = 20000;
    private final static int TREE_PRICE = 10000;
    private final static int STAR_PRICE = 5000;
    private final int totalDiscountPrice;

    private EventBadgeService(int totalDiscountPrice) {
        this.totalDiscountPrice = totalDiscountPrice;
    }

    public static EventBadgeService of(int totalDiscountPrice) {
        return new EventBadgeService(totalDiscountPrice);
    }

    public String execute() {
        if (totalDiscountPrice >= SANTA_PRICE) {
            return SANTA_BADGE;
        }
        if (totalDiscountPrice >= TREE_PRICE) {
            return TREE_BADGE;
        }
        if (totalDiscountPrice >= STAR_PRICE) {
            return STAR_BADGE;
        }
        return NO_BADGE;
    }
}
