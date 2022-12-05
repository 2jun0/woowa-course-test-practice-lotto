package lotto.view;

import java.util.StringJoiner;
import lotto.domain.Lotto;
import lotto.domain.LottoPrize;

public class OutputFormatter {

    String formatLottoNumbers(Lotto lotto) {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        lotto.numbers().stream()
                .map(number -> Integer.toString(number))
                .forEach(joiner::add);

        return joiner.toString();
    }

    String formatLottoPrizeCount(LottoPrize lottoPrize, int count) {
        if (LottoPrize.SECOND.equals(lottoPrize)) {
            return String.format("%s개 일치, 보너스 볼 일치 (%,d원) - %d개",
                    lottoPrize.matchCount(), lottoPrize.prize(), count);
        }

        return String.format("%s개 일치 (%,d원) - %d개",
                lottoPrize.matchCount(), lottoPrize.prize(), count);
    }
}
