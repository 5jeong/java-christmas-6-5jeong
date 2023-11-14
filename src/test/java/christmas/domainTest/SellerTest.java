package christmas.domainTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.domain.Seller;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SellerTest {

    @DisplayName("주문내역을 올바르게 입력한 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"타파스-1,제로콜라-1", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1"})
    void 주문내역이_올바른경우_예외테스트(String orderHistoty) {
        assertThatCode(() -> new Seller(orderHistoty)).doesNotThrowAnyException();
    }

    @DisplayName("중복된 메뉴가 있을때 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"티본스테이크-1,바비큐립-1,바비큐립-2", "티본스테이크-1,티본스테이크-1,티본스테이크-2"})
    void 메뉴에_중복된_메뉴가_있을때_예외테스트(String orderHistoty) {
        assertThatThrownBy(() -> new Seller(orderHistoty)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴판에 메뉴가 없을때 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"티본스테이크-1,바비큐립-1,꿔바로우-2", "짜장면-1,탕수육-1,사이다-2"})
    void 메뉴판_없는_메뉴가_있을때_예외테스트(String orderHistoty) {
        assertThatThrownBy(() -> new Seller(orderHistoty)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("주문한 메뉴의 개수가 1개 이상 20개 이하가 아닐때 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"티본스테이크-0,바비큐립-0,초코케이크-2", "티본스테이크-23,티본스테이크-41,티본스테이크-112"})
    void 주문한_메뉴의_개수가_1개이상_20개이하가_아닐때_예외테스트(String orderHistoty) {
        assertThatThrownBy(() -> new Seller(orderHistoty)).isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("주문한 메뉴가 음료만 있을때 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"제로콜라-1,레드와인-1,샴페인-2", "제로콜라-1,제로콜라-1,제로콜라-2"})
    void 주문한_메뉴가_음료만_있을때_예외테스트(String orderHistoty) {
        assertThatThrownBy(() -> new Seller(orderHistoty)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("주문한 메뉴들의 총 주문금액을 테스트 ")
    @Test
    void 총_주문금액_테스트() {
        Seller seller1 = new Seller("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
        int totalOrderAmount = seller1.totalOrderAmount();
        assertThat(totalOrderAmount).isEqualTo(142000);

        Seller seller2 = new Seller("타파스-1,제로콜라-1 ");
        int totalOrderAmount2 = seller2.totalOrderAmount();
        assertThat(totalOrderAmount2).isEqualTo(8500);
    }
}
