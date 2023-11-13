package christmas.domain;

public class ServiceEvent {
    private static final int SERVICE_BENEFIT = 25000;
    private static final int NO_BENEFIT_AMOUNT = 0;

    public int calculateBenefit(boolean isService) {
        if (isService) {
            return SERVICE_BENEFIT;
        }
        return NO_BENEFIT_AMOUNT;
    }
}
