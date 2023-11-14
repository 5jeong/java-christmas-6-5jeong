package christmas.domain;

import christmas.view.OutputConstants;
import java.util.stream.IntStream;

public class PromotionEvent {
    private static final int MINIMUM_APPLY_EVENT_AMOUNT = 10000;

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

    private boolean isPromotionEvent() {
        int totalOrderAmount = seller.totalOrderAmount();
        return totalOrderAmount >= MINIMUM_APPLY_EVENT_AMOUNT;
    }

    public int totalBenefitAmount() {
        if (isPromotionEvent()) {
            return totalDiscountAmount() + applyServiceBenefit();
        }
        return OutputConstants.ZERO_AMOUNT;
    }

    public int totalDiscountAmount() {
        if (isPromotionEvent()) {
            return IntStream.of(
                    applyChristmasDiscount(),
                    applyWeekdayDiscount(),
                    applyWeekendDiscount(),
                    applySpecialDiscount()
            ).sum();
        }
        return OutputConstants.ZERO_AMOUNT;
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
        return eventGift.getEventGift(totalBenefitAmount());
    }
}
