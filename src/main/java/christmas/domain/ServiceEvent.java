package christmas.domain;

public class ServiceEvent {
    private static final int MINIMUM_SERVICE_AMOUNT = 120000;

    private static final int SERVICE_BENEFIT = 25000;
    private static final int NO_BENEFIT_AMOUNT = 0;

    public int calculateBenefit(int totalOrderAmount) {
        if (isServiceMenu(totalOrderAmount)) {
            return SERVICE_BENEFIT;
        }
        return NO_BENEFIT_AMOUNT;
    }
    private boolean isServiceMenu(int totalOrderAmount) {
        return totalOrderAmount >= MINIMUM_SERVICE_AMOUNT;
    }
}
