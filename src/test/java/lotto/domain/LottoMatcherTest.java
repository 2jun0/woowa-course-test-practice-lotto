package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoMatcherTest {

    private LottoMatcher lottoMatcher;

    @BeforeEach
    void initializeLottoMatcher() {
        lottoMatcher = new LottoMatcher();
    }

    @ParameterizedTest(name = "match {argumentsWithNames}")
    @MethodSource("provideMatch")
    void match(Lotto lotto, WinningNumbers winningNumbers, BonusNumber bonusNumber,
            LottoPrize expect) {
        LottoPrize lottoPrize = lottoMatcher.match(lotto, winningNumbers, bonusNumber);
        assertThat(lottoPrize).isEqualTo(expect);
    }

    static Stream<Arguments> provideMatch() {
        return Stream.of(
                Arguments.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new WinningNumbers(List.of(1, 2, 3, 4, 5, 6)),
                        new BonusNumber(7),
                        LottoPrize.FIRST),
                Arguments.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new WinningNumbers(List.of(1, 2, 3, 4, 5, 7)),
                        new BonusNumber(6),
                        LottoPrize.SECOND),
                Arguments.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new WinningNumbers(List.of(1, 2, 3, 4, 5, 8)),
                        new BonusNumber(45),
                        LottoPrize.THIRD),
                Arguments.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new WinningNumbers(List.of(1, 2, 3, 4, 7, 8)),
                        new BonusNumber(45),
                        LottoPrize.FOURTH),
                Arguments.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new WinningNumbers(List.of(1, 2, 3, 7, 8, 9)),
                        new BonusNumber(45),
                        LottoPrize.FIFTH));
    }
}