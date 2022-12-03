package lotto.view;

import java.util.StringJoiner;
import lotto.domain.Lotto;

class OutputFormatter {

    String formatLottoNumbers(Lotto lotto) {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        lotto.numbers().stream()
                .map(number -> Integer.toString(number))
                .forEach(joiner::add);

        return joiner.toString();
    }
}
