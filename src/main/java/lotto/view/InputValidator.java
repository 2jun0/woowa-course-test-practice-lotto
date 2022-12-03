package lotto.view;

public class InputValidator {

    public static final String LOTTO_PURCHASE_MONEY_REGEX = "^\\d+$";
    public static final String BONUS_NUMBER_REGEX = "^\\d+$";
    public static final String WINNING_NUMBERS_REGEX = "^\\d+,\\d+,\\d+,\\d+,\\d+,\\d+$";

    void validateLottoPurchaseMoney(String money) {
        if (!money.matches(LOTTO_PURCHASE_MONEY_REGEX)) {
            throw new IllegalArgumentException("로또 구입 금액은 숫자여야 합니다.");
        }
    }

    public void validateWinningNumbers(String winningNumbers) {
        if (!winningNumbers.matches(WINNING_NUMBERS_REGEX)) {
            throw new IllegalArgumentException("당첨 번호는 \"숫자,숫자,숫자,숫자,숫자,숫자\" 형식으로 입력해주세요");
        }
    }

    void validateBonusNumber(String bonusNumber) {
        if (!bonusNumber.matches(BONUS_NUMBER_REGEX)) {
            throw new IllegalArgumentException("보너스 번호는 숫자여야 합니다.");
        }
    }
}
