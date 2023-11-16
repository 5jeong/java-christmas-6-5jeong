package christmas.domainTest;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.DayOfWeek;
import christmas.domain.WeekdayDiscount;
import christmas.util.ConverterUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WeekdayDiscountTest {

    private WeekdayDiscount weekdayDiscount;

    @BeforeEach
    public void generateWeekdayDiscount() {
        weekdayDiscount = new WeekdayDiscount();
    }

    @DisplayName("평일 할인 적용 테스트")
    @Test
    void 평일_할인_적용_테스트() {
        String orderMenu = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";
        Map<String, Integer> orderHistory = ConverterUtil.convertStringToMap(orderMenu);
        List<DayOfWeek> dayOfWeeks = new ArrayList<>(
                List.of(DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY,
                        DayOfWeek.SUNDAY));

        for (DayOfWeek dayOfWeek : dayOfWeeks) {
            int weekdayDiscountAmount = weekdayDiscount.calculateDiscount(dayOfWeek, orderHistory);
            assertThat(weekdayDiscountAmount).isEqualTo(4046);
        }
    }

    @DisplayName("주말인경우, 평일 할인 미적용 테스트")
    @Test
    void 주말일때_평일_할인_미적용_테스트() {
        String orderMenu = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";
        Map<String, Integer> orderHistory = ConverterUtil.convertStringToMap(orderMenu);
        List<DayOfWeek> dayOfWeeks = new ArrayList<>(List.of(DayOfWeek.FRIDAY, DayOfWeek.SATURDAY));

        for (DayOfWeek dayOfWeek : dayOfWeeks) {
            int weekdayDiscountAmount = weekdayDiscount.calculateDiscount(dayOfWeek, orderHistory);
            assertThat(weekdayDiscountAmount).isEqualTo(0);
        }
    }

    @DisplayName("평일이지만 디저트메뉴를 시키지않을때, 평일 할인 미적용 테스트")
    @Test
    void 평일일때_평일_할인_미적용_테스트() {
        String orderMenu = "티본스테이크-1,바비큐립-1,제로콜라-1";
        Map<String, Integer> orderHistory = ConverterUtil.convertStringToMap(orderMenu);
        List<DayOfWeek> dayOfWeeks = new ArrayList<>(
                List.of(DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY,
                        DayOfWeek.SUNDAY));

        for (DayOfWeek dayOfWeek : dayOfWeeks) {
            int weekdayDiscountAmount = weekdayDiscount.calculateDiscount(dayOfWeek, orderHistory);
            assertThat(weekdayDiscountAmount).isEqualTo(0);
        }
    }
}
