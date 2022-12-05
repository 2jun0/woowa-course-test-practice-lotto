package lotto.domain;

import static lotto.domain.Lotto.LOTTO_MAX_NUMBER_INCLUSIVE;
import static lotto.domain.Lotto.LOTTO_MIN_NUMBER_INCLUSIVE;
import static lotto.domain.Lotto.LOTTO_NUMBER_COUNT;

import java.util.List;

public class WinningNumbers {

    private final List<Integer> winningNumbers;

    public WinningNumbers(List<Integer> winningNumbers) {
        validateWinningNumbersSize(winningNumbers);
        validateWinningNumbersRange(winningNumbers);
        validateWinningNumbersDuplicate(winningNumbers);

        this.winningNumbers = winningNumbers;
    }

    private void validateWinningNumbersSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(
                    String.format("당첨번호의 개수는 %d여야 합니다.", LOTTO_NUMBER_COUNT));
        }
    }

    private void validateWinningNumbersRange(List<Integer> winningNumbers) {
        winningNumbers.forEach(this::validateWinningNumberRange);
    }

    private void validateWinningNumberRange(int winningNumber) {
        if (LOTTO_MIN_NUMBER_INCLUSIVE > winningNumber
                || winningNumber > LOTTO_MAX_NUMBER_INCLUSIVE) {
            throw new IllegalArgumentException(String.format("당첨번호는 %d부터 %d사이의 정수여야 합니다.",
                    LOTTO_MIN_NUMBER_INCLUSIVE, LOTTO_MAX_NUMBER_INCLUSIVE));
        }
    }

    private void validateWinningNumbersDuplicate(List<Integer> winningNumbers) {
        if (winningNumbers.stream().distinct().count() != winningNumbers.size()) {
            throw new IllegalArgumentException("당첨번호는 중복된 숫자가 들어가면 안됩니다.");
        }
    }

    public int matchCount(Lotto lotto) {
        return (int) winningNumbers.stream()
                .filter(lotto::contains)
                .count();
    }

    public boolean contains(int number) {
        return winningNumbers.contains(number);
    }

    @Override
    public String toString() {
        return "WinningNumbers{" +
                "winningNumbers=" + winningNumbers +
                '}';
    }
}
