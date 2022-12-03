package lotto.domain;

import static java.util.stream.Collectors.toMap;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

public enum LottoPrize {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5000);

    private final int matchCount;
    private final int prize;

    private static final Map<Integer, LottoPrize> matchCountToLottoPrizeWithoutBonus =
            Stream.of(values())
                    .filter(lottoPrize -> lottoPrize != SECOND)
                    .collect(toMap(lottoPrize -> lottoPrize.matchCount, Function.identity()));

    LottoPrize(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    static LottoPrize find(boolean isMatchedBonus, int matchCount) {
        if (isMatchedBonus && matchCount == SECOND.matchCount) {
            return SECOND;
        }

        return matchCountToLottoPrizeWithoutBonus.get(matchCount);
    }

    public int matchCount() { return matchCount; }

    public int prize() {
        return prize;
    }
}
