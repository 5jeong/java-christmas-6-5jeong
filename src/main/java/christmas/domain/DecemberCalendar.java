package christmas.domain;

import java.util.ArrayList;
import java.util.List;

public class DecemberCalendar {

    // 각 날짜에 해당하는 요일을 저장하는 리스트
    private List<DayOfWeek> daysOfWeeks;

    // 생성자에서 12월의 달력 초기화
    public DecemberCalendar() {
        initDecemberCalendar();
    }

    // 12월의 달력 초기화 메소드
    private void initDecemberCalendar() {
        daysOfWeeks = new ArrayList<>();

        // 12월 1일은 금요일부터 시작
        DayOfWeek currentDay = DayOfWeek.FRIDAY;

        for (int day = 1; day <= 31; day++) {
            daysOfWeeks.add(currentDay);
            // 다음 날로 이동
            currentDay = getNextDayOfWeek(currentDay);
        }
    }

    // 다음 날 요일을 계산하는 메소드
    private DayOfWeek getNextDayOfWeek(DayOfWeek currentDay) {
        int nextDayIndex = (currentDay.ordinal() + 1) % 7;
        return DayOfWeek.values()[nextDayIndex];
    }

    // 날짜에 해당하는 요일 반환 메소드
    public DayOfWeek getDayOfWeek(int day) {
        return daysOfWeeks.get(day - 1);
    }
}