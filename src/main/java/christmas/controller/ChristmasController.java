package christmas.controller;

import christmas.InputHandler.InputTemplate;
import christmas.domain.Buyer;
import christmas.domain.PromotionEvent;
import christmas.domain.Seller;
import christmas.view.InputView;
import christmas.view.OutputConstants;
import christmas.view.OutputView;
import java.util.Map;

public class ChristmasController {
    private final InputView inputView;
    private final OutputView outputView;

    public ChristmasController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void christmasPromotion() {
        Buyer buyer = generateBuyer();
        Seller seller = generateSeller();
        confirmOrderStep(buyer, seller);
        PromotionEvent promotionEvent = generatePromotionEvent(buyer, seller);
        applyDiscountStep(promotionEvent);
    }

    private void confirmOrderStep(Buyer buyer, Seller seller) {
        displayEventPreview(buyer.getVisitDay());
        displayOrderMenu(seller.getOrderHistory());
        displayTotalOrderAmount(seller.totalOrderAmount());
    }

    private void applyDiscountStep(PromotionEvent promotionEvent) {
        displayServiceMenuMessage(promotionEvent.applyServiceBenefit());
        displayBenefitHistory(promotionEvent.totalBenefitAmount());
        displayBenefits(promotionEvent);
        displayTotalBenefitMessage(promotionEvent.totalBenefitAmount());
        displayExpectPaymentAmount(promotionEvent.expectPaymentAmount());
        displayEventGiftMessage(promotionEvent.eventGift());
    }

    private Buyer generateBuyer() {
        outputView.startEventMessageOutput();
        return InputTemplate.execute(() -> {
            String visitDate = inputView.expectedVisitDateInput();
            return new Buyer(visitDate);
        });
    }

    private Seller generateSeller() {
        return InputTemplate.execute(() -> {
            String orderMenuAndCount = inputView.orderMenuAndCountInput();
            return new Seller(orderMenuAndCount);
        });
    }

    private PromotionEvent generatePromotionEvent(Buyer buyer, Seller seller) {
        return new PromotionEvent(buyer, seller);
    }

    private void displayEventPreview(int visitDay) {
        outputView.eventPreviewMessageOutput(visitDay);
    }

    private void displayOrderMenu(Map<String, Integer> orderHistory) {
        outputView.orderMenuOutput(orderHistory);
    }

    private void displayTotalOrderAmount(int totalOrderAmount) {
        outputView.totalOrderAmountOutput(totalOrderAmount);
    }

    private void displayServiceMenuMessage(int serviceBenefit) {
        outputView.serviceMenuMessageOutput(serviceBenefit);
    }

    private void displayBenefitHistory(int totalBenefitAmount) {
        outputView.benefitHistoryOutput(totalBenefitAmount);
    }

    private void displayBenefits(PromotionEvent promotionEvent) {
        if (promotionEvent.totalBenefitAmount() != OutputConstants.ZERO_AMOUNT) {
            outputView.christmasDiscountOutput(promotionEvent.applyChristmasDiscount());
            outputView.weekdayDiscountOutput(promotionEvent.applyWeekdayDiscount());
            outputView.weekendDiscountOutput(promotionEvent.applyWeekendDiscount());
            outputView.specialDiscountOutput(promotionEvent.applySpecialDiscount());
            outputView.serviceBenefitOutput(promotionEvent.applyServiceBenefit());
        }
    }

    private void displayTotalBenefitMessage(int totalBenefitAmount) {
        outputView.totalBenefitMessageOutput(totalBenefitAmount);
    }

    private void displayExpectPaymentAmount(int expectPaymentAmount) {
        outputView.expectPaymentAmountOutput(expectPaymentAmount);
    }

    private void displayEventGiftMessage(String eventGift) {
        outputView.eventGiftMessageOutput(eventGift);
    }
}
