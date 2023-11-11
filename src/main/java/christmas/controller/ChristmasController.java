package christmas.controller;

import christmas.domain.Buyer;
import christmas.domain.PromotionEvent;
import christmas.domain.Seller;
import christmas.view.InputView;
import christmas.view.OutputView;

public class ChristmasController {
    private final InputView inputView;
    private final OutputView outputView;

    public ChristmasController(){
        this.inputView= new InputView();
        this.outputView = new OutputView();
    }

    public void christmasPromotion() {


        Buyer buyer = generateBuyer();
        Seller seller = generateSeller();
        previewBenefit(buyer,seller);

    }

    private void previewBenefit(Buyer buyer, Seller seller) {
        outputView.orderMenuOutput(seller.getOrderHistory());
        outputView.totalOrderAmountOutput(seller.totalOrderAmount());
        outputView.serviceMenuMessageOutput(seller.isServiceMenu());
        PromotionEvent promotionEvent = new PromotionEvent(buyer, seller);
        int totalDiscoutAmount = promotionEvent.totalDiscountAmount();
        int totalBenefitAmount = promotionEvent.totalBenefitAmount();
        int expectPaymentAmount = seller.totalOrderAmount() - totalDiscoutAmount;
        outputView.benefitHistoryOutput(totalBenefitAmount);
        if(totalBenefitAmount!=0){
            outputView.christmasDiscountOutput(promotionEvent.applyChristmasDiscount());
            outputView.weekdayDiscountOutput(promotionEvent.applyWeekdayDiscount());
            outputView.weekendDiscountOutput(promotionEvent.applyWeekendDiscount());
            outputView.serviceBenefitOutput(promotionEvent.applySpecialDiscount());
            outputView.serviceBenefitOutput(promotionEvent.applyServiceBenefit());
        }
        outputView.totalBenefitMessageOutput(totalBenefitAmount);
        outputView.expectPaymentAmountOutput(expectPaymentAmount);
        outputView.eventGiftMessageOutput(promotionEvent.SpecailPresent(totalBenefitAmount));

    }


    private Buyer generateBuyer(){
        while (true) {
            try {
                String visitDate = inputView.expectedVisitDateInput();
                return new Buyer(visitDate);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            }
        }
//        String visitDate = inputView.expectedVisitDateInput();
//        return new Buyer(visitDate);
    }

    private Seller generateSeller(){
        while (true) {
            try {
                String orderMenuAndCount = inputView.orderMenuAndCountInput();
                return new Seller(orderMenuAndCount);
            } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
                System.out.println("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        }
//        String orderMenuAndCount = inputView.orderMenuAndCountInput();
//        return new Seller(orderMenuAndCount);
    }
}
