package christmas.domainTest;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.ChristmasDiscount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ChristmasDiscountTest {

    private ChristmasDiscount christmasDiscount;

    @BeforeEach
    public void generateChristmasDiscount() {
        christmasDiscount = new ChristmasDiscount();
    }

    @DisplayName("크리스마스 할인 적용 테스트")
    @Test
    void 크리스마스_할인_적용_테스트() {
        int christmasDiscountAmount1 = christmasDiscount.calculateDiscount(3);
        assertThat(christmasDiscountAmount1).isEqualTo(1200);

        int christmasDiscountAmount2 = christmasDiscount.calculateDiscount(25);
        assertThat(christmasDiscountAmount2).isEqualTo(3400);
    }

    @DisplayName("크리스마스 할인 미적용 테스트")
    @ParameterizedTest
    @ValueSource(ints = {26, 27, 31})
    void 크리스마스_할인_미적용_테스트(int visitDate) {
        int christmasDiscountAmount = christmasDiscount.calculateDiscount(visitDate);
        assertThat(christmasDiscountAmount).isEqualTo(0);

    }

}
