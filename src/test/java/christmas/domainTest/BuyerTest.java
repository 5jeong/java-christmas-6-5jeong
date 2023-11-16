package christmas.domainTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.domain.Buyer;
import christmas.domain.DayOfWeek;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BuyerTest {
    @DisplayName("구매자의 방문날짜가 올바르게 입력한 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1", "12", "25"})
    void 구매자의_방문날짜가_올바른경우_예외테스트(String vistiDate) {
        assertThatCode(()-> new Buyer(vistiDate)).doesNotThrowAnyException();
    }

    @DisplayName("구매자의 방문날짜가 숫자가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"aaa", "12as", "@@!D"})
    void 구매자의_방문날짜가_숫자가_아닐때_예외테스트(String vistiDate) {
        assertThatThrownBy(() -> new Buyer(vistiDate)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매자의 방문날짜가 1일 ~ 31일이 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "32", "123"})
    void 구매자의_방문날짜가_1일이상_31일이하가_아닐때_예외테스트(String vistiDate) {
        assertThatThrownBy(() -> new Buyer(vistiDate)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매자의 방문날짜가 어떤요일인지 테스트")
    @Test
    void 구매자의_방문요일_테스트() {
        Buyer buyer1 = new Buyer("1");
        DayOfWeek visitDayOfWeek = buyer1.visitDayOfWeek();
        assertThat(visitDayOfWeek).isEqualTo(DayOfWeek.FRIDAY);

        Buyer buyer2 = new Buyer("25");
        DayOfWeek visitDayOfWeek2 = buyer2.visitDayOfWeek();
        assertThat(visitDayOfWeek2).isEqualTo(DayOfWeek.MONDAY);
    }
}
