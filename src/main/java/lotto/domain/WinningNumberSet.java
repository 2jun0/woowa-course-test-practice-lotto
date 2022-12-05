package lotto.domain;

public class WinningNumberSet {

    private final WinningNumbers winningNumbers;
    private final BonusNumber bonusNumber;

    public WinningNumberSet(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        validateDuplicate(winningNumbers, bonusNumber);

        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicate(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        if (winningNumbers.contains(bonusNumber.bonusNumber())) {
            throw new IllegalArgumentException("당첨 번호와 보너스 번호는 중복될 수 없습니다.");
        }
    }

    public LottoPrize match(Lotto lotto) {
        int matchCount = winningNumbers.matchCount(lotto);
        boolean isMatchedBonus = bonusNumber.match(lotto);

        return LottoPrize.find(isMatchedBonus, matchCount);
    }

    @Override
    public String toString() {
        return "WinningNumberSet{" +
                "winningNumbers=" + winningNumbers +
                ", bonusNumber=" + bonusNumber +
                '}';
    }
}
