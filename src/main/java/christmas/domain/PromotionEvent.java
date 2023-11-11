package christmas.domain;

import java.util.stream.IntStream;

public class PromotionEvent {

    private ChristmasDiscount christmasDiscount = new ChristmasDiscount();
    private WeekdayDiscount weekdayDiscount = new WeekdayDiscount();
    private WeekendDiscount weekendDiscount = new WeekendDiscount();
    private SpecialDiscount specialDiscount = new SpecialDiscount();
    private ServiceEvent serviceEvent = new ServiceEvent();

    private final Buyer buyer;
    private final Seller seller;

    public PromotionEvent(Buyer buyer, Seller seller) {
        this.buyer = buyer;
        this.seller = seller;
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
        return serviceEvent.calculateBenefit(seller.isServiceMenu());
    }

    public String SpecailPresent(int totalBenefitAmount) {
        if (totalBenefitAmount >= 20000) {
            return "산타";
        }
        if (totalBenefitAmount >= 10000) {
            return "트리";
        }
        if (totalBenefitAmount >= 5000) {
            return "별";
        }
        return "없음";
    }

}
