package christmas.domain;

public class SpecialDiscount {
    private static final int SPECIAL_DISCOUNT = 1000;
    private static final int NO_DISCOUNT_AMOUNT = 0;

    public int calculateDiscount(int visitDay) {
        if (isSpecialEvent(visitDay)) {
            return SPECIAL_DISCOUNT;
        }
        return NO_DISCOUNT_AMOUNT;
    }

    private boolean isSpecialEvent(int visitDay) {
        DecemberCalendar decemberCalendar = new DecemberCalendar();
        return decemberCalendar.isSpecialDay(visitDay);
    }
}
