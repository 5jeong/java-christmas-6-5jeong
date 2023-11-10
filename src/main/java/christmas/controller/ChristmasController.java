package christmas.controller;

import christmas.domain.Buyer;
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
    }


    private Buyer generateBuyer(){
        String visitDate = inputView.expectedVisitDateInput();
        return new Buyer(visitDate);
    }

    private Seller generateSeller(){
        String orderMenuAndCount = inputView.orderMenuAndCountInput();
        return new Seller(orderMenuAndCount);
    }
}
