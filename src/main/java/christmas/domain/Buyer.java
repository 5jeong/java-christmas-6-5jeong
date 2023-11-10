package christmas.domain;

import christmas.util.ConverterUtil;
import java.util.regex.Pattern;

public class Buyer {
    private final static String VISIT_DATE_INPUT_ERROR = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";
    private static final String VISIT_DATE_REGEX = "[0-9]+";
    private static final int MIN_DATE = 1;
    private static final int MAX_DATE = 31;

    private static int visitDate;

    public Buyer(String visitDate) {
        validateDate(visitDate);
        this.visitDate = ConverterUtil.convertStringToInt(visitDate);
    }

    public DayOfWeek visitDayOfWeek(int visitDate) {
        DecemberCalendar decemberCalendar = new DecemberCalendar();
        return decemberCalendar.getDayOfWeek(visitDate);
    }

    private void validateDate(String visitDate) {
        if (isNotDigit(visitDate)) {
            throw new IllegalArgumentException(VISIT_DATE_INPUT_ERROR);
        }
        if (isNotDateNumber(visitDate)) {
            throw new IllegalArgumentException(VISIT_DATE_INPUT_ERROR);
        }
    }

    private static boolean isNotDigit(String visitDate) {
        return !Pattern.compile(VISIT_DATE_REGEX).matcher(visitDate).matches();
    }

    private static boolean isNotDateNumber(String visitDate) {
        int date = ConverterUtil.convertStringToInt(visitDate);
        return date < MIN_DATE || date > MAX_DATE;
    }

    public int getVisitDate() {
        return visitDate;
    }
}
