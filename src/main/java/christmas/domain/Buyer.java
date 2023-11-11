package christmas.domain;

import christmas.util.ConverterUtil;
import java.util.regex.Pattern;

public class Buyer {
    private final static String VISIT_DATE_INPUT_ERROR = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";
    private static final String VISIT_DATE_REGEX = "[0-9]+";
    private static final int MIN_DATE = 1;
    private static final int MAX_DATE = 31;

    private static int visitDay;

    public Buyer(String visitDate) {
        validateDate(visitDate);
        this.visitDay = ConverterUtil.convertStringToInt(visitDate);
    }

    public DayOfWeek visitDayOfWeek() {
        DecemberCalendar decemberCalendar = new DecemberCalendar();
        return decemberCalendar.getDayOfWeek(visitDay);
    }

    private void validateDate(String visitDate) {

        if (isNotDigit(visitDate)) {
            throw new IllegalArgumentException();
        }
        if (isNotDateNumber(visitDate)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isNotDigit(String visitDate) {
        return !Pattern.compile(VISIT_DATE_REGEX).matcher(visitDate).matches();
    }

    private static boolean isNotDateNumber(String visitDate) {
        int date = ConverterUtil.convertStringToInt(visitDate);
        return date < MIN_DATE || date > MAX_DATE;
    }

    public int getVisitDay() {
        return visitDay;
    }
}
