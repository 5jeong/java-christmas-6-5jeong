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
    Map<String, Integer> orderHistory;

    @BeforeEach
    public void generateWeekdayDiscount() {
        weekdayDiscount = new WeekdayDiscount();
        orderHistory = ConverterUtil.convertStringToMap("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
    }

    @DisplayName("평일 할인 적용 테스트")
    @Test
    void 평일_할인_적용_테스트() {
        List<DayOfWeek> dayOfWeeks = new ArrayList<>(
                List.of(DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY,
                        DayOfWeek.SUNDAY));
        for (DayOfWeek dayOfWeek : dayOfWeeks) {
            int weekdayDiscountAmount = weekdayDiscount.calculateDiscount(dayOfWeek, orderHistory);
            assertThat(weekdayDiscountAmount).isEqualTo(4046);
        }
    }

    @DisplayName("평일 할인 미적용 테스트")
    @Test
    void 평일_할인_미적용_테스트() {
        List<DayOfWeek> dayOfWeeks = new ArrayList<>(List.of(DayOfWeek.FRIDAY, DayOfWeek.SATURDAY));
        for (DayOfWeek dayOfWeek : dayOfWeeks) {
            int weekdayDiscountAmount = weekdayDiscount.calculateDiscount(dayOfWeek, orderHistory);
            assertThat(weekdayDiscountAmount).isEqualTo(0);
        }
    }
}
