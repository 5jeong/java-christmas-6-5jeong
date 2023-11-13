package christmas.domainTest;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.SpecialDiscount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SpecialDiscountTest {

    private SpecialDiscount specialDiscount;

    @BeforeEach
    public void generateSpecialDiscount() {
        specialDiscount = new SpecialDiscount();
    }

    @DisplayName("크리스마가 아닐때,특별 할인 적용 테스트")
    @ParameterizedTest
    @ValueSource(ints = {3, 10, 17, 24, 31})
    void 특별_할인_적용_테스트(int visitDay) {
        int specialDiscountAmount = specialDiscount.calculateDiscount(visitDay);
        assertThat(specialDiscountAmount).isEqualTo(1000);
    }

    @DisplayName("크리스마일때, 특별 할인 적용 테스트")
    @Test
    void 특별_할인_적용_테스트() {
        int visitDay = 25;
        int specialDiscountAmount = specialDiscount.calculateDiscount(visitDay);
        assertThat(specialDiscountAmount).isEqualTo(1000);
    }

    @DisplayName("특별 할인 미적용 테스트")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 특별_할인_미적용_테스트(int visitDay) {
        int specialDiscountAmount = specialDiscount.calculateDiscount(visitDay);
        assertThat(specialDiscountAmount).isEqualTo(0);
    }
}
