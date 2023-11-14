package christmas.viewTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.view.InputViewValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidatorTest {
    private InputViewValidator inputViewValidator;

    @BeforeEach
    public void generateInputValidator() {
        inputViewValidator = new InputViewValidator();
    }

    @DisplayName("메뉴와 갯수사이의 -가 아닐때 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"티본스테이크~1,바비큐립=1", "티본스테이크 1,바비큐립 1,초코케이크 2"})
    void 메뉴_갯수사이의_검증테스트(String orderMenuInput) {
        assertThatThrownBy(() -> inputViewValidator.validateMenuFormat(orderMenuInput)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @DisplayName("메뉴사이의 ,(콤마)로 구분하지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"티본스테이크-1+바비큐립-1+초코케이크-2", "티본스테이크-1^바비큐립-1^초코케이크-2"})
    void 메뉴들_사이의_콤마검증_테스트(String orderMenuInput) {
        assertThatThrownBy(() -> inputViewValidator.validateMenuFormat(orderMenuInput)).isInstanceOf(
                IllegalArgumentException.class);
    }
}
