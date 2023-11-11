package christmas.domain;

public class ChristmasDiscount {
    private static final int START_DATE = 1;
    private static final int CHRISTMAS_DATE = 25;
    private static final int INITIAL_DISCOUNT = 1000;
    private static final int DAILY_DISCOUNT_INCREASE = 100;


    public int calculateDiscount(int visitDate) {
        if (isChristmasEvent(visitDate)) {
            return calculateChristmasDiscount(visitDate);
        }
        return 0;
    }

    private boolean isChristmasEvent(int visitDay) {
        return visitDay <= CHRISTMAS_DATE;
    }

    private int calculateChristmasDiscount(int visitDate) {

        int daysBetween = visitDate - START_DATE;
        int discountAmount = INITIAL_DISCOUNT + daysBetween * DAILY_DISCOUNT_INCREASE;

        return discountAmount;
    }


}
