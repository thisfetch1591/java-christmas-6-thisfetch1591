package christmas.constants;

import static christmas.constants.ErrorType.CAN_NOT_FOUND_MENU;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum Menu {
    NOT_EXIST_MENU("없음", 0, 0),
    MUSHROOM_CREAM_SOUP("양송이수프", 6000, 1),
    TAPAS("타파스", 5500, 1),
    CAESAR_SALAD("시저샐러드", 8000, 1),
    T_BONE_STEAK("티본스테이크", 55000, 2),
    BARBECUE_LIP("바비큐립", 54000, 2),
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

    public static Menu find(String menuName) {
        return Arrays.stream(values())
                .filter(menu -> menu.nameOfMenu.equals(menuName))
                .findAny()
                .orElseThrow(() -> new NoSuchElementException(CAN_NOT_FOUND_MENU.getErrorMessage()));
    }

    public int getCostOfMenu() {
        return costOfMenu;
    }

    public String getNameOfMenu() {
        return nameOfMenu;
    }

    public boolean isMainMenu() {
        return codeOfMenu == 2;
    }

    public boolean isDessert() {
        return codeOfMenu == 3;
    }

    public boolean isDrink() {
        return codeOfMenu == 4;
    }

    public boolean isSameName(String menuName) {
        return menuName.equals(nameOfMenu);
    }
}
