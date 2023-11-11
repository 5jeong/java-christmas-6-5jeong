package christmas.view;

import java.text.DecimalFormat;
import java.util.Map;

public class OutputView {
    private static final String ORDER_MENU = "%s %d개";
    private static final String AMOUNT_MESSAGE = "%s원";
    private static final String CHRISTMAS_DISCOUNT = "크리스마스 디데이 할인: -%s원";
    private static final String WEEKDAY_DISCOUNT = "평일 할인: -%s원";
    private static final String WEEKEND_DISCOUNT = "주말 할인: -%s원";
    private static final String SPECIAL_DISCOUNT = "특별 할인: -%s원";
    private static final String SERVICE_BENEFIT = "증정이벤트: -%s원";
    private static final String EVENT_PREVIEW_MESSAGE = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private static final String ORDER_MENU_MESSAGE = "<주문 메뉴>";
    private static final String TOTAL_ORDER_AMOUNT = "<할인 전 총주문 금액>";
    private static final String SERVICE_MENU_MESSAGE = "<증정 메뉴>";
    private static final String BENEFIT_MESSAGE = "<혜택 내역>";
    private static final String TOTAL_BENEFIT_MESSAGE = "<총혜택 금액>";
    private static final String TOTAL_BENEFIT = "-%s원";

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
            System.out.println(String.format(ORDER_MENU, menu, orderMenu.get(menu)));
        }
    }

    public void totalOrderAmountOutput(int totalOrderAmount) {
        System.out.println();
        System.out.println(TOTAL_ORDER_AMOUNT);
        System.out.println(String.format(AMOUNT_MESSAGE, formatter.format(totalOrderAmount)));

    }

    public void serviceMenuMessageOutput(boolean isServiceMenu) {
        System.out.println();
        System.out.println(SERVICE_MENU_MESSAGE);
        if (isServiceMenu) {
            System.out.println("샴페인 1개");
            return;
        }
        System.out.println("없음");
    }

    public void benefitHistoryOutput(int totalBenefitAmount) {
        System.out.println();
        System.out.println(BENEFIT_MESSAGE);
        if (totalBenefitAmount == 0) {
            System.out.println("없음");
        }
    }

    public void christmasDiscountOutput(int christmasDiscountAmount) {
        if (christmasDiscountAmount != 0) {
            System.out.println(String.format(CHRISTMAS_DISCOUNT, formatter.format(christmasDiscountAmount)));
        }
    }

    public void weekdayDiscountOutput(int weekdayDiscountAmount) {
        if (weekdayDiscountAmount != 0) {
            System.out.println(String.format(WEEKDAY_DISCOUNT, formatter.format(weekdayDiscountAmount)));
        }
    }

    public void weekendDiscountOutput(int weekendDiscountAmount) {
        if (weekendDiscountAmount != 0) {
            System.out.println(String.format(WEEKEND_DISCOUNT, formatter.format(weekendDiscountAmount)));
        }
    }

    public void SpecialDiscountOutput(int specialDiscountAmount) {
        if (specialDiscountAmount != 0) {
            System.out.println(String.format(SPECIAL_DISCOUNT, formatter.format(specialDiscountAmount)));
        }
    }

    public void serviceBenefitOutput(int serviceBenefitAmount) {
        if (serviceBenefitAmount != 0) {
            System.out.println(String.format(SERVICE_BENEFIT, formatter.format(serviceBenefitAmount)));
        }
    }

    public void totalBenefitMessageOutput(int totalBenefitAmount) {
        System.out.println();
        System.out.println(TOTAL_BENEFIT_MESSAGE);
        if (totalBenefitAmount != 0) {
            System.out.println(String.format("-" + AMOUNT_MESSAGE, formatter.format(totalBenefitAmount)));
            return;
        }
        System.out.println(String.format(AMOUNT_MESSAGE, formatter.format(totalBenefitAmount)));
    }

    public void expectPaymentAmountOutput(int expectPaymentAmount) {
        System.out.println();
        System.out.println(EXPECT_PAYMENT_AMOUNT_MESSAGE);
        System.out.println(String.format(AMOUNT_MESSAGE, formatter.format(expectPaymentAmount)));
    }

    public void eventGiftMessageOutput(String present) {
        System.out.println();
        System.out.println(EVENT_GIFT_MESSAGE);
        System.out.println(present);
    }


}
