package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningNumberSetTest {

    @ParameterizedTest(name = "match {argumentsWithNames}")
    @MethodSource("provideMatch")
    void match(WinningNumberSet winningNumberSet, Lotto lotto, LottoPrize expect) {
        LottoPrize lottoPrize = winningNumberSet.match(lotto);
        assertThat(lottoPrize).isEqualTo(expect);
    }

    static Stream<Arguments> provideMatch() {
        return Stream.of(
                Arguments.of(
                        new WinningNumberSet(
                                new WinningNumbers(List.of(1, 2, 3, 4, 5, 6)),
                                new BonusNumber(7)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        LottoPrize.FIRST),
                Arguments.of(
                        new WinningNumberSet(
                                new WinningNumbers(List.of(1, 2, 3, 4, 5, 7)),
                                new BonusNumber(6)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        LottoPrize.SECOND),
                Arguments.of(
                        new WinningNumberSet(
                                new WinningNumbers(List.of(1, 2, 3, 4, 5, 8)),
                                new BonusNumber(45)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        LottoPrize.THIRD),
                Arguments.of(
                        new WinningNumberSet(
                                new WinningNumbers(List.of(1, 2, 3, 4, 7, 8)),
                                new BonusNumber(45)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        LottoPrize.FOURTH),
                Arguments.of(
                        new WinningNumberSet(
                                new WinningNumbers(List.of(1, 2, 3, 7, 8, 9)),
                                new BonusNumber(45)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        LottoPrize.FIFTH));
    }
}