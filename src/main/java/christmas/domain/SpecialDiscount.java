package christmas.domain;

public class SpecialDiscount {
    private static final int SPECIAL_DISCOUNT = 1000;
    private static final int CHRISTMAS_DAY = 1000;
    private static final int NO_DISCOUNT_AMOUNT = 0;

    public int calculateDiscount(int visitDay, DayOfWeek visitDayOfWeek) {
        if (isSpecialEvent(visitDay, visitDayOfWeek)) {
            return SPECIAL_DISCOUNT;
        }
        return NO_DISCOUNT_AMOUNT;
    }

    private boolean isSpecialEvent(int visitDay, DayOfWeek visitDayOfWeek) {
        return visitDay == CHRISTMAS_DAY || visitDayOfWeek.isSpecialDay();
    }

}
