package lotto.view;

public class InputValidator {

    public static final String LOTTO_PURCHASE_MONEY_REGEX = "^\\d+$";
    public static final String BONUS_NUMBER_REGEX = "^\\d+$";

    void validateLottoPurchaseMoney(String money) {
        if (!money.matches(LOTTO_PURCHASE_MONEY_REGEX)) {
            throw new IllegalArgumentException("로또 구입 금액은 숫자여야 합니다.");
        }
    }

    void validateBonusNumber(String bonusNumber) {
        if (!bonusNumber.matches(BONUS_NUMBER_REGEX)) {
            throw new IllegalArgumentException("보너스 번호는 숫자여야 합니다.");
        }
    }
}
