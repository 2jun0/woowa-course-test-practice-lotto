package lotto.domain;

import java.util.List;

public class WinningNumbers {

    private final List<Integer> winningNumbers;

    public WinningNumbers(List<Integer> standardNumbers) {
        this.winningNumbers = standardNumbers;
    }

    public int matchCount(Lotto lotto) {
        return (int) winningNumbers.stream()
                .filter(lotto::contains)
                .count();
    }
}
