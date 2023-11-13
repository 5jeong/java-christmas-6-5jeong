package christmas.domain;

import java.util.stream.IntStream;

public class PromotionEvent {

    private final ChristmasDiscount christmasDiscount;
    private final WeekdayDiscount weekdayDiscount;
    private final WeekendDiscount weekendDiscount;
    private final SpecialDiscount specialDiscount;
    private final ServiceEvent serviceEvent;
    private final EventGift eventGift;

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
        this.eventGift = new EventGift();
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
        return specialDiscount.calculateDiscount(buyer.getVisitDay());
    }

    public int applyServiceBenefit() {
        return serviceEvent.calculateBenefit(seller.totalOrderAmount());
    }

    public String eventGift() {
        return eventGift.eventGift(totalBenefitAmount());
    }
}
