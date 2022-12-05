package lotto.domain;

import static lotto.domain.LottoPrize.FIFTH;
import static lotto.domain.LottoPrize.FIRST;
import static lotto.domain.LottoPrize.FOURTH;
import static lotto.domain.LottoPrize.SECOND;
import static lotto.domain.LottoPrize.THIRD;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class WinningResultsTest {

    @Test
    void countOfPrize() {
        WinningResults winningResults = new WinningResults(
                List.of(FIRST, SECOND, FIRST, THIRD, FOURTH, FIFTH));
        Map<LottoPrize, Integer> countOfPrize = winningResults.countOfPrize();

        assertThat(countOfPrize)
                .isEqualTo(Map.of(FIRST, 2, SECOND, 1, THIRD, 1, FOURTH, 1, FIFTH, 1));
    }
}