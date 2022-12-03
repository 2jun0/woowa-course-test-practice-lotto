package lotto.domain;

import java.util.List;

public class YieldCalculator {

    public double yield(List<LottoPrize> lottoPrizes, int purchaseMoney) {
        return (double) sumOfPrize(lottoPrizes) / purchaseMoney;
    }

    private int sumOfPrize(List<LottoPrize> lottoPrizes) {
        return lottoPrizes.stream()
                .mapToInt(LottoPrize::prize)
                .sum();
    }
}
