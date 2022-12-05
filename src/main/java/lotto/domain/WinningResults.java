package lotto.domain;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

public class WinningResults {

    private final Map<LottoPrize, Integer> countOfPrize;

    public WinningResults(List<LottoPrize> lottoPrizes) {
        this.countOfPrize = countOfPrize(lottoPrizes);
    }

    private Map<LottoPrize, Integer> countOfPrize(List<LottoPrize> lottoPrizes) {
        return lottoPrizes.stream()
                .filter(Objects::nonNull)
                .collect(groupingBy(Function.identity(), summingInt(x -> 1)));
    }

    public Map<LottoPrize, Integer> countOfPrize() {
        return Collections.unmodifiableMap(countOfPrize);
    }
}
