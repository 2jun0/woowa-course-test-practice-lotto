package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}