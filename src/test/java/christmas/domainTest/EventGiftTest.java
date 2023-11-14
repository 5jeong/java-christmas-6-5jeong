package christmas.domainTest;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.EventGift;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class EventGiftTest {
    private EventGift eventGift;

    @BeforeEach
    public void generateEventGift() {
        eventGift = new EventGift();
    }

    @DisplayName("이벤트 선물이 별일 때 테스트 ")
    @ParameterizedTest
    @ValueSource(ints = {5000, 8000, 9000})
    void 이벤트_선물이_별일때_테스트(int totalBenefitAmount) {
        String gift = eventGift.getEventGift(totalBenefitAmount);
        assertThat(gift).isEqualTo("별");
    }

    @DisplayName("이벤트 선물이 트리일 때 테스트 ")
    @ParameterizedTest
    @ValueSource(ints = {10000, 15000, 19000})
    void 이벤트_선물이_트리일때_테스트(int totalBenefitAmount) {
        String gift = eventGift.getEventGift(totalBenefitAmount);
        assertThat(gift).isEqualTo("트리");
    }

    @DisplayName("이벤트 선물이 산타일 때 테스트 ")
    @ParameterizedTest
    @ValueSource(ints = {20000, 28000, 39000})
    void 이벤트_선물이_산타일때_테스트(int totalBenefitAmount) {
        String gift = eventGift.getEventGift(totalBenefitAmount);
        assertThat(gift).isEqualTo("산타");
    }

    @DisplayName("이벤트 선물을 못받았을때 테스트 ")
    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 4000})
    void 이벤트_선물을_못받았을때_테스트(int totalBenefitAmount) {
        String gift = eventGift.getEventGift(totalBenefitAmount);
        assertThat(gift).isEqualTo("없음");
    }

}
