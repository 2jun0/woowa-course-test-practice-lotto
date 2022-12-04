package lotto.domain;

import java.util.List;

public class WinningNumbers {

    private final List<Integer> winningNumbers;

    public WinningNumbers(List<Integer> winningNumbers) {
        validateWinningNumbersSize(winningNumbers);

        this.winningNumbers = winningNumbers;
    }

    private void validateWinningNumbersSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != Lotto.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(
                    String.format("당첨번호의 개수는 %d여야 합니다.", Lotto.LOTTO_NUMBER_COUNT));
        }
    }

    public int matchCount(Lotto lotto) {
        return (int) winningNumbers.stream()
                .filter(lotto::contains)
                .count();
    }

    @Override
    public String toString() {
        return "WinningNumbers{" +
                "winningNumbers=" + winningNumbers +
                '}';
    }
}
