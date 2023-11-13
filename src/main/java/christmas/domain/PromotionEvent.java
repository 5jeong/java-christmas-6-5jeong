package christmas.domain;

import java.util.stream.IntStream;

public class PromotionEvent {
    private static final int MINIMUM_SERVICE_AMOUNT = 120000;
    private static final int MINIMUM_STAR_GIFT_AMOUNT = 5000;
    private static final int MINIMUM_TREE_GIFT_AMOUNT = 10000;
    private static final int MINIMUM_SANTA_GIFT_AMOUNT = 20000;

    private final ChristmasDiscount christmasDiscount;
    private final WeekdayDiscount weekdayDiscount;
    private final WeekendDiscount weekendDiscount;
    private final SpecialDiscount specialDiscount;
    private final ServiceEvent serviceEvent;

    private final Buyer buyer;
    private final Seller seller;

    public PromotionEvent(Buyer buyer, Seller seller) {
        this.buyer = buyer;
        this.seller = seller;
        this.christmasDiscount = new ChristmasDiscount();
        this.weekdayDiscount = new WeekdayDiscount();
        this.weekendDiscount = new WeekendDiscount();
        this.specialDiscount = new SpecialDiscount();
        this.serviceEvent = new ServiceEvent();
    }

    public boolean isServiceMenu() {
        return seller.totalOrderAmount() >= MINIMUM_SERVICE_AMOUNT;
    }

    public int totalBenefitAmount() {
        return totalDiscountAmount() + applyServiceBenefit();
    }

    public int totalDiscountAmount() {
        return IntStream.of(
                applyChristmasDiscount(),
                applyWeekdayDiscount(),
                applyWeekendDiscount(),
                applySpecialDiscount()
        ).sum();
    }

    public int expectPaymentAmount() {
        int expectPaymentAmount = seller.totalOrderAmount() - totalDiscountAmount();
        return expectPaymentAmount;
    }

    public int applyChristmasDiscount() {
        return christmasDiscount.calculateDiscount(buyer.getVisitDay());
    }

    public int applyWeekdayDiscount() {
        return weekdayDiscount.calculateDiscount(buyer.visitDayOfWeek(), seller.getOrderHistory());
    }

    public int applyWeekendDiscount() {
        return weekendDiscount.calculateDiscount(buyer.visitDayOfWeek(), seller.getOrderHistory());
    }

    public int applySpecialDiscount() {
        return specialDiscount.calculateDiscount(buyer.getVisitDay(), buyer.visitDayOfWeek());
    }

    public int applyServiceBenefit() {
        return serviceEvent.calculateBenefit(isServiceMenu());
    }


    public String eventGift() {
        int totalBenefitAmount = totalBenefitAmount();
        return determineEventGift(totalBenefitAmount);
    }

    private String determineEventGift(int totalBenefitAmount) {
        if (totalBenefitAmount >= MINIMUM_SANTA_GIFT_AMOUNT) {
            return "산타";
        }
        if (totalBenefitAmount >= MINIMUM_TREE_GIFT_AMOUNT) {
            return "트리";
        }
        if (totalBenefitAmount >= MINIMUM_STAR_GIFT_AMOUNT) {
            return "별";
        }
        return "없음";
    }

}
