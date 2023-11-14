package christmas.controller;

import christmas.InputHandler.InputTemplate;
import christmas.domain.Buyer;
import christmas.domain.PromotionEvent;
import christmas.domain.Seller;
import christmas.view.InputView;
import christmas.view.OutputConstants;
import christmas.view.OutputView;

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
        displayEventPreview(buyer);
        displayOrderMenu(seller);
        displayTotalOrderAmount(seller);
    }

    private void applyDiscountStep(PromotionEvent promotionEvent) {
        displayServiceMenuMessage(promotionEvent);
        displayBenefitHistory(promotionEvent);
        displayBenefits(promotionEvent);
        displayTotalBenefitMessage(promotionEvent);
        displayExpectPaymentAmount(promotionEvent);
        displayEventGiftMessage(promotionEvent);
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

    private void displayEventPreview(Buyer buyer) {
        outputView.eventPreviewMessageOutput(buyer.getVisitDay());
    }

    private void displayOrderMenu(Seller seller) {
        outputView.orderMenuOutput(seller.getOrderHistory());
    }

    private void displayTotalOrderAmount(Seller seller) {
        outputView.totalOrderAmountOutput(seller.totalOrderAmount());
    }

    private void displayServiceMenuMessage(PromotionEvent promotionEvent) {
        outputView.serviceMenuMessageOutput(promotionEvent.applyServiceBenefit());
    }

    private void displayBenefitHistory(PromotionEvent promotionEvent) {
        outputView.benefitHistoryOutput(promotionEvent.totalBenefitAmount());
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

    private void displayTotalBenefitMessage(PromotionEvent promotionEvent) {
        outputView.totalBenefitMessageOutput(promotionEvent.totalBenefitAmount());
    }

    private void displayExpectPaymentAmount(PromotionEvent promotionEvent) {
        int expectPaymentAmount = promotionEvent.expectPaymentAmount();
        outputView.expectPaymentAmountOutput(expectPaymentAmount);
    }

    private void displayEventGiftMessage(PromotionEvent promotionEvent) {
        outputView.eventGiftMessageOutput(promotionEvent.eventGift());
    }
}
