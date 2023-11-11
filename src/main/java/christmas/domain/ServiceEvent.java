package christmas.domain;

public class ServiceEvent {
    private static final int SERVICE_BENEFIT = 25000;

    public int calculateBenefit(boolean isService) {
        if (isService) {
            return SERVICE_BENEFIT;
        }
        return 0;
    }
}
