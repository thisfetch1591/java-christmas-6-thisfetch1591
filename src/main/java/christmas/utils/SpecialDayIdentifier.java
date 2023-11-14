package christmas.utils;

public class SpecialDayIdentifier {

    private final static int WEEK_COUNT = 7;
    private final static int START_SPECIAL_DATE = 3;
    private final static int XMAS_DATE = 25;

    private final int inputDate;

    private SpecialDayIdentifier(int inputDate) {
        this.inputDate = inputDate;
    }

    public static SpecialDayIdentifier of(int inputDate) {
        return new SpecialDayIdentifier(inputDate);
    }

    public boolean isSpecialDay() {
        return inputDate % WEEK_COUNT == START_SPECIAL_DATE || inputDate == XMAS_DATE;
    }
}
