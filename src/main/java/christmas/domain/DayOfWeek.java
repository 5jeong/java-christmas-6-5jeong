package christmas.domain;

public enum DayOfWeek {
    SUNDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY;

    public boolean isWeekday() {
        return this != FRIDAY && this != SATURDAY;
    }

    public boolean isWeekend() {
        return this == FRIDAY || this == SATURDAY;
    }
}
