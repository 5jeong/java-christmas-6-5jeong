package christmas.domain;

public class EventGift {
    private static final int MINIMUM_STAR_GIFT_AMOUNT = 5000;
    private static final int MINIMUM_TREE_GIFT_AMOUNT = 10000;
    private static final int MINIMUM_SANTA_GIFT_AMOUNT = 20000;
    private static final String STAR_GIFT = "별";
    private static final String TREE_GIFT = "트리";
    private static final String SANTA_GIFT = "산타";
    private static final String NO_GIFT = "없음";

    public String getEventGift(int totalBenefitAmount) {
        if(isEventGift(totalBenefitAmount)){
            return determineEventGift(totalBenefitAmount);
        }
        return NO_GIFT;
    }

    private boolean isEventGift(int totalBenefitAmount) {
        return totalBenefitAmount >= MINIMUM_STAR_GIFT_AMOUNT;
    }

    private String determineEventGift(int totalBenefitAmount) {
        if (totalBenefitAmount >= MINIMUM_SANTA_GIFT_AMOUNT) {
            return SANTA_GIFT;
        }
        if (totalBenefitAmount >= MINIMUM_TREE_GIFT_AMOUNT) {
            return TREE_GIFT;
        }
        return STAR_GIFT;
    }
}
