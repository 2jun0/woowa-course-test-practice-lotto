package lotto.domain;

import java.util.Map;

public class YieldCalculator {

    public double yield(WinningResults winningResults, int money) {
        return (double) sumOfPrize(winningResults.countOfPrize()) / money;
    }

    private int sumOfPrize(Map<LottoPrize, Integer> countOfPrize) {
        return countOfPrize.entrySet().stream()
                .mapToInt(entry -> entry.getKey().prize() * entry.getValue())
                .sum();
    }
}
