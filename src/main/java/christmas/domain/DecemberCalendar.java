package christmas.domain;

import java.util.ArrayList;
import java.util.List;

public class DecemberCalendar {
    private static final int DECEMBER_START_DAY = 1;
    private static final int DECEMBER_END_DAY = 31;
    private static final int NUMBER_OF_WEEKS = 7;

    private List<DayOfWeek> daysOfWeeks;

    public DecemberCalendar() {
        initDecemberCalendar();
    }

    private void initDecemberCalendar() {
        daysOfWeeks = new ArrayList<>();
        DayOfWeek startDay = DayOfWeek.FRIDAY;

        for (int day = DECEMBER_START_DAY; day <= DECEMBER_END_DAY; day++) {
            daysOfWeeks.add(startDay);
            startDay = getNextDayOfWeek(startDay);
        }
    }

    private DayOfWeek getNextDayOfWeek(DayOfWeek currentDay) {
        int nextDayIndex = (currentDay.ordinal() + 1) % NUMBER_OF_WEEKS;
        return DayOfWeek.values()[nextDayIndex];
    }

    public DayOfWeek getDayOfWeek(int day) {
        return daysOfWeeks.get(day - 1);
    }
}