package christmas.domainTest;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.Buyer;
import christmas.domain.PromotionEvent;
import christmas.domain.Seller;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PromotionEventTest {


    @DisplayName("할인이 있을때, 총할인 금액 테스트")
    @Test
    void 할인이_있을때_총할인_금액_테스트() {
        Buyer buyer = new Buyer("3");
        Seller seller = new Seller("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
        PromotionEvent promotionEvent = new PromotionEvent(buyer, seller);

        int totalDiscountAmount = promotionEvent.totalDiscountAmount();
        assertThat(totalDiscountAmount).isEqualTo(6246);
    }

    @DisplayName("주문금액이 10000원이상이지만, 할인이 없을때, 총할인 금액 테스트")
    @Test
    void 주문금액이_10000원_이상이지만_할인이_없을때_총_할인_금액_테스트() {
        Buyer buyer = new Buyer("26");
        Seller seller = new Seller("타파스-1,제로콜라-1");
        PromotionEvent promotionEvent = new PromotionEvent(buyer, seller);

        int totalDiscountAmount = promotionEvent.totalDiscountAmount();
        assertThat(totalDiscountAmount).isEqualTo(0);
    }

    @DisplayName("주문금액이 10000원보다 작을때, 총할인 금액 테스트")
    @Test
    void 주문금액이_10000원보다_작을때_총_할인_금액_테스트() {
        Buyer buyer = new Buyer("25");
        Seller seller = new Seller("시저샐러드-1");
        PromotionEvent promotionEvent = new PromotionEvent(buyer, seller);

        int totalDiscountAmount = promotionEvent.totalDiscountAmount();
        assertThat(totalDiscountAmount).isEqualTo(0);
    }

    @DisplayName("혜택이 있을때, 총혜택 금액 테스트")
    @Test
    void 혜택이_있을때_총_혜택_금액_테스트() {
        Buyer buyer = new Buyer("3");
        Seller seller = new Seller("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
        PromotionEvent promotionEvent = new PromotionEvent(buyer, seller);

        int totalBenefitAmount = promotionEvent.totalBenefitAmount();
        assertThat(totalBenefitAmount).isEqualTo(31246);
    }

    @DisplayName("주문금액이 10000원이상이지만 혜택이 없을때, 총혜택 금액 테스트")
    @Test
    void 주문금액이_10000원_이상이지만_혜택이_없을때_총_혜택_금액_테스트() {
        Buyer buyer = new Buyer("26");
        Seller seller = new Seller("타파스-1,제로콜라-1");
        PromotionEvent promotionEvent = new PromotionEvent(buyer, seller);

        int totalBenefitAmount = promotionEvent.totalBenefitAmount();
        assertThat(totalBenefitAmount).isEqualTo(0);
    }

    @DisplayName("주문금액이 10000원보다 작을때, 총혜택 금액 테스트")
    @Test
    void 주문금액이_10000원보다_작을때_총_혜택_금액_테스트() {
        Buyer buyer = new Buyer("26");
        Seller seller = new Seller("시저샐러드-1");
        PromotionEvent promotionEvent = new PromotionEvent(buyer, seller);

        int totalBenefitAmount = promotionEvent.totalBenefitAmount();
        assertThat(totalBenefitAmount).isEqualTo(0);
    }

    @DisplayName("할인 후 예상 결제금액 테스트")
    @Test
    void 할인_후_예상_결제금액_테스트() {
        Buyer buyer = new Buyer("3");
        Seller seller = new Seller("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
        PromotionEvent promotionEvent = new PromotionEvent(buyer, seller);

        int expectPaymentAmount = promotionEvent.expectPaymentAmount();
        assertThat(expectPaymentAmount).isEqualTo(135754);
    }
}
