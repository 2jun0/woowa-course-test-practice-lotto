package lotto.domain;

public class BonusNumber {

    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public boolean match(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }
}
