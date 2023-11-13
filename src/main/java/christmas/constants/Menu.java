package christmas.constants;

public enum Menu {
    MUSHROOM_CREAM_SOUP("양송이수프", 6000, 1),
    TAPAS("타파스", 5500, 1),
    CAESAR_SALAD("시저샐러드", 8000, 1),
    T_BONE_STEAK("티본스테이크", 55000, 2),
    BARBECUE_LIP("바베큐립", 54000, 2),
    SEAFOOD_PASTA("해산물파스타", 35000, 2),
    XMAS_PASTA("크리스마스파스타", 25000, 2),
    CHOCOLATE_CAKE("초코케이크", 15000, 3),
    ICE_CREAM("아이스크림", 5000, 3),
    ZERO_COKE("제로콜라", 3000, 4),
    RED_WINE("레드와인", 60000, 4),
    CHAMPAGNE("샴페인", 25000, 4);
    private String nameOfMenu;
    private int costOfMenu;
    private int codeOfMenu;

    private Menu(String nameOfMenu, int costOfMenu, int codeOfMenu) {
        this.nameOfMenu = nameOfMenu;
        this.costOfMenu = costOfMenu;
        this.codeOfMenu = codeOfMenu;
    }

    public int addPrice(int totalPrice) {
        return totalPrice += costOfMenu;
    }

    public boolean isDrink() {
        if (codeOfMenu == 4) {
            return true;
        }
        return false;
    }
}
