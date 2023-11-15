package christmas.utils;

public class WeekdayWeekendIdentifier {

    private final static int START_FRIDAY_DATE = 1;
    private final static int START_SATURDAY_DATE = 2;
    private final static int WEEK_COUNT = 7;

    private final int inputDate;

    private WeekdayWeekendIdentifier(int inputDate) {
        this.inputDate = inputDate;
    }

    public static WeekdayWeekendIdentifier of(int inputDate) {
        return new WeekdayWeekendIdentifier(inputDate);
    }

    public boolean isWeekend() {
        return inputDate % WEEK_COUNT == START_FRIDAY_DATE || inputDate % WEEK_COUNT == START_SATURDAY_DATE;
    }
}
