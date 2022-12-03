package lotto.domain;

public class LottoMatcher {

    public LottoPrize match(Lotto lotto, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        int matchCount = winningNumbers.matchCount(lotto);
        boolean isMatchedBonus = bonusNumber.match(lotto);

        return LottoPrize.find(isMatchedBonus, matchCount);
    }
}
