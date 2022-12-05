package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import lotto.domain.LottoPrize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class OutputFormatterTest {

    private OutputFormatter outputFormatter;

    @BeforeEach
    void initializeOutputFormatter() {
        outputFormatter = new OutputFormatter();
    }

    @Test
    void formatLottoNumbers() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        String formatLottoNumbers = outputFormatter.formatLottoNumbers(lotto);

        assertThat(formatLottoNumbers).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @ParameterizedTest(name = "formatLottoPrizeCount {argumentsWithNames}")
    @MethodSource("provideFormatLottoPrizeCount")
    void formatLottoPrizeCount(LottoPrize lottoPrize, int count, String expect) {
        String formatted = outputFormatter.formatLottoPrizeCount(lottoPrize, count);
        assertThat(formatted).isEqualTo(expect);
    }

    static Stream<Arguments> provideFormatLottoPrizeCount() {
        return Stream.of(
                Arguments.of(LottoPrize.SECOND, 2, "5개 일치, 보너스 볼 일치 (30,000,000원) - 2개"),
                Arguments.of(LottoPrize.FIRST, 3, "6개 일치 (2,000,000,000원) - 3개"));
    }
}