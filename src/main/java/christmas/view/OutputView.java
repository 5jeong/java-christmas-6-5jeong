package christmas.view;

import java.text.DecimalFormat;
import java.util.Map;

public class OutputView {
    private static final String ORDER_MENU = "%s %d개";
    private static final String TOTAL_ORDER = "%s원";

    private static final String EVENT_PREVIEW_MESSAGE = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private static final String ORDER_MENU_MESSAGE = "<주문 메뉴>";
    private static final String TOTAL_ORDER_AMOUNT = "<할인 전 총주문 금액>";
    private static final String SERVICE_MENU_MESSAGE = "<증정 메뉴>";
    private static final String BENEFIT_MESSAGE = "<혜택 내역>";
    private static final String TOTAL_BENEFIT_MESSAGE_MESSAGE = "<총혜택 금액>";
    private static final String EXPECT_PAYMENT_AMOUNT_MESSAGE = "<할인 후 예상 결제 금액>";
    private static final String EVENT_GIFT_MESSAGE = "<12월 이벤트 배지>";

    private static DecimalFormat formatter = new DecimalFormat("###,###");


    public void eventPreviewMessageOutput() {
        System.out.println(EVENT_PREVIEW_MESSAGE);
    }

    public void orderMenuOutput(Map<String, Integer> orderMenu) {
        System.out.println();
        System.out.println(ORDER_MENU_MESSAGE);
        for (String menu : orderMenu.keySet()) {
            System.out.println(String.format(ORDER_MENU,menu,orderMenu.get(menu)));
        }
    }

    public void totalOrderAmountOutput(int totalOrderAmount) {
        System.out.println();
        System.out.println(TOTAL_ORDER_AMOUNT);
        System.out.println(String.format(TOTAL_ORDER,formatter.format(totalOrderAmount)));

    }

    public void serviceMenuMessageOutput(boolean isServiceMenu) {
        System.out.println();
        System.out.println(SERVICE_MENU_MESSAGE);
        if(isServiceMenu){
            System.out.println("샴페인 1개");
            return;
        }
        System.out.println("없음");
    }

    public void benefitMessageOutput() {
        System.out.println();
        System.out.println(BENEFIT_MESSAGE);
    }

    public void totalBenefitMessageOutput() {
        System.out.println();
        System.out.println(TOTAL_BENEFIT_MESSAGE_MESSAGE);
    }

    public void expectPaymentAmountOutput() {
        System.out.println();
        System.out.println(EXPECT_PAYMENT_AMOUNT_MESSAGE);
    }

    public void eventGiftMessageOutput() {
        System.out.println();
        System.out.println(EVENT_GIFT_MESSAGE);
    }


}
