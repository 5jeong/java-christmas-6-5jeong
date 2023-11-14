package christmas.view;

import java.text.DecimalFormat;
import java.util.Map;

public class OutputView {
    private static final DecimalFormat formatter = new DecimalFormat("###,###");

    public void startEventMessageOutput() {
        System.out.println(OutputConstants.START_EVENT_MESSAGE);
    }

    public void eventPreviewMessageOutput(int visitDay) {
        System.out.println(String.format(OutputConstants.EVENT_PREVIEW_MESSAGE, visitDay));
    }

    public void orderMenuOutput(Map<String, Integer> orderMenu) {
        System.out.println();
        System.out.println(OutputConstants.ORDER_MENU_MESSAGE);
        for (String menu : orderMenu.keySet()) {
            System.out.println(String.format(OutputConstants.ORDER_MENU, menu, orderMenu.get(menu)));
        }
    }

    public void totalOrderAmountOutput(int totalOrderAmount) {
        System.out.println();
        System.out.println(OutputConstants.TOTAL_ORDER_AMOUNT);
        System.out.println(String.format(OutputConstants.AMOUNT_MESSAGE, formatter.format(totalOrderAmount)));
    }

    public void serviceMenuMessageOutput(int serviceBenefit) {
        System.out.println();
        System.out.println(OutputConstants.SERVICE_MENU_MESSAGE);
        if (serviceBenefit != OutputConstants.ZERO_AMOUNT) {
            System.out.println(OutputConstants.SERVICE_MENU);
            return;
        }
        System.out.println(OutputConstants.NO_BENEFIT_MESSAGE);
    }

    public void benefitHistoryOutput(int totalBenefitAmount) {
        System.out.println();
        System.out.println(OutputConstants.BENEFIT_MESSAGE);
        if (totalBenefitAmount == OutputConstants.ZERO_AMOUNT) {
            System.out.println(OutputConstants.NO_BENEFIT_MESSAGE);
        }
    }

    public void christmasDiscountOutput(int christmasDiscountAmount) {
        if (christmasDiscountAmount != OutputConstants.ZERO_AMOUNT) {
            System.out.println(
                    String.format(OutputConstants.CHRISTMAS_DISCOUNT, formatter.format(christmasDiscountAmount)));
        }
    }

    public void weekdayDiscountOutput(int weekdayDiscountAmount) {
        if (weekdayDiscountAmount != OutputConstants.ZERO_AMOUNT) {
            System.out.println(
                    String.format(OutputConstants.WEEKDAY_DISCOUNT, formatter.format(weekdayDiscountAmount)));
        }
    }

    public void weekendDiscountOutput(int weekendDiscountAmount) {
        if (weekendDiscountAmount != OutputConstants.ZERO_AMOUNT) {
            System.out.println(
                    String.format(OutputConstants.WEEKEND_DISCOUNT, formatter.format(weekendDiscountAmount)));
        }
    }

    public void specialDiscountOutput(int specialDiscountAmount) {
        if (specialDiscountAmount != OutputConstants.ZERO_AMOUNT) {
            System.out.println(
                    String.format(OutputConstants.SPECIAL_DISCOUNT, formatter.format(specialDiscountAmount)));
        }
    }

    public void serviceBenefitOutput(int serviceBenefitAmount) {
        if (serviceBenefitAmount != OutputConstants.ZERO_AMOUNT) {
            System.out.println(String.format(OutputConstants.SERVICE_BENEFIT, formatter.format(serviceBenefitAmount)));
        }
    }

    public void totalBenefitMessageOutput(int totalBenefitAmount) {
        System.out.println();
        System.out.println(OutputConstants.TOTAL_BENEFIT_MESSAGE);
        if (totalBenefitAmount != OutputConstants.ZERO_AMOUNT) {
            System.out.println(
                    String.format(OutputConstants.BENEFIT_AMOUNT_MESSAGE, formatter.format(totalBenefitAmount)));
            return;
        }
        System.out.println(String.format(OutputConstants.AMOUNT_MESSAGE, OutputConstants.ZERO_AMOUNT));
    }

    public void expectPaymentAmountOutput(int expectPaymentAmount) {
        System.out.println();
        System.out.println(OutputConstants.EXPECT_PAYMENT_AMOUNT_MESSAGE);
        System.out.println(String.format(OutputConstants.AMOUNT_MESSAGE, formatter.format(expectPaymentAmount)));
    }

    public void eventGiftMessageOutput(String present) {
        System.out.println();
        System.out.println(OutputConstants.EVENT_GIFT_MESSAGE);
        System.out.println(present);
    }
}
