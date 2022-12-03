package lotto.view;

public class InputValidator {

    public static final String LOTTO_PURCHASE_MONEY_REGEX = "^\\d+$";

    void validateLottoPurchaseMoney(String money) {
        if (!money.matches(LOTTO_PURCHASE_MONEY_REGEX)) {
            throw new IllegalArgumentException("로또 구입 금액은 숫자여야 합니다.");
        }
    }
}
