package christmas.domain;

public class SpecialDiscount {
    private static final int SPECIAL_DISCOUNT = 1000;

    public int calculateDiscount(int visitDay, DayOfWeek visitDayOfWeek) {
        if (isSpecialEvent(visitDay, visitDayOfWeek)) {
            return SPECIAL_DISCOUNT;
        }
        return 0;
    }

    private boolean isSpecialEvent(int visitDay, DayOfWeek visitDayOfWeek) {
        return visitDay == 25 || visitDayOfWeek.isSpecialDay();
    }

}
