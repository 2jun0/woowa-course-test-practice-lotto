package lotto.domain;

public class BonusNumber {

    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        validateBonusNumber(bonusNumber);

        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber) {
        if (Lotto.LOTTO_MIN_NUMBER_INCLUSIVE > bonusNumber
                || bonusNumber > Lotto.LOTTO_MAX_NUMBER_INCLUSIVE) {
            throw new IllegalArgumentException(
                    String.format("보너스 번호는 %d부터 %d까지여야 합니다.",
                            Lotto.LOTTO_MIN_NUMBER_INCLUSIVE,
                            Lotto.LOTTO_MAX_NUMBER_INCLUSIVE));
        }
    }

    public boolean match(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }

    public int bonusNumber() {
        return bonusNumber;
    }

    @Override
    public String toString() {
        return "BonusNumber{" +
                "bonusNumber=" + bonusNumber +
                '}';
    }
}
