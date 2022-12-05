package lotto.domain;

public class WinningNumberSet {

    private final WinningNumbers winningNumbers;
    private final BonusNumber bonusNumber;

    public WinningNumberSet(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public LottoPrize match(Lotto lotto) {
        int matchCount = winningNumbers.matchCount(lotto);
        boolean isMatchedBonus = bonusNumber.match(lotto);

        return LottoPrize.find(isMatchedBonus, matchCount);
    }
}
