package christmas.domainTest;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.ServiceEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ServieEventTest {
    private ServiceEvent serviceEvent;

    @BeforeEach
    public void generateServiceEvent() {
        serviceEvent = new ServiceEvent();
    }

    @DisplayName("증정 이벤트 적용 테스트 ")
    @ParameterizedTest
    @ValueSource(ints = {120000, 150000, 2000000})
    void 증정_이벤트_적용_테스트(int totalOrderAmount) {
        int serviceBenefitAmount = serviceEvent.calculateBenefit(totalOrderAmount);
        assertThat(serviceBenefitAmount).isEqualTo(25000);
    }


    @DisplayName("증정 이벤트 미적용 테스트 ")
    @ParameterizedTest
    @ValueSource(ints = {10000, 50000, 110000})
    void 증정_이벤트_미적용_테스트(int totalOrderAmount) {
        int serviceBenefitAmount = serviceEvent.calculateBenefit(totalOrderAmount);
        assertThat(serviceBenefitAmount).isEqualTo(0);
    }

}
