package lotto.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

    InputValidator inputValidator;

    @BeforeEach
    void initializeInputValidator() {
        inputValidator = new InputValidator();
    }

    @Nested
    class ValidateLottoPurchaseMoneyTest {

        @ParameterizedTest(name = "fail {argumentsWithNames}")
        @ValueSource(strings = {".", "1s1", "", "1,000"})
        void fail(String money) {
            assertThatThrownBy(
                            () -> inputValidator.validateLottoPurchaseMoney(money))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("로또 구입 금액은 정수여야 합니다.");
        }

        @ParameterizedTest(name = "success {argumentsWithNames}")
        @ValueSource(strings = {"3000", "1000"})
        void success(String money) {
            inputValidator.validateLottoPurchaseMoney(money);
        }
    }

    @Nested
    class ValidateWinningNumbersTest {

        @ParameterizedTest(name = "fail {argumentsWithNames}")
        @ValueSource(strings = {".", "1,2,3,4,5", ""})
        void fail(String winningNumbers) {
            assertThatThrownBy(
                            () -> inputValidator.validateWinningNumbers(winningNumbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("당첨 번호는 \"정수,정수,정수,정수,정수,정수\" 형식으로 입력해주세요");
        }

        @ParameterizedTest(name = "success {argumentsWithNames}")
        @ValueSource(strings = {"1,2,34,5,6,7"})
        void success(String winningNumbers) {
            inputValidator.validateWinningNumbers(winningNumbers);
        }
    }

    @Nested
    class ValidateBonusNumberTest {

        @ParameterizedTest(name = "fail {argumentsWithNames}")
        @ValueSource(strings = {".", "1s1", "", "1,000"})
        void fail(String bonusNumber) {
            assertThatThrownBy(
                            () -> inputValidator.validateBonusNumber(bonusNumber))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("보너스 번호는 정수여야 합니다.");
        }

        @ParameterizedTest(name = "success {argumentsWithNames}")
        @ValueSource(strings = {"3", "45"})
        void success(String bonusNumber) {
            inputValidator.validateBonusNumber(bonusNumber);
        }
    }
}