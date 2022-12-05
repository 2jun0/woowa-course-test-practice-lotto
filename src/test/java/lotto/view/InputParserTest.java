package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputParserTest {

    private InputParser inputParser;

    @BeforeEach
    void initializeInputParser() {
        inputParser = new InputParser();
    }

    @Test
    void parseLottoPurchaseMoney() {
        String lottoPurchaseMoney = "1000";
        int parsedLottoPurchaseMoney = inputParser.parseLottoPurchaseMoney(lottoPurchaseMoney);

        assertThat(parsedLottoPurchaseMoney).isEqualTo(1000);
    }

    @Test
    void parseWinningNumbers() {
        String winningNumbers = "1,2,3,4,5,6";
        List<Integer> parsedWinningNumbers = inputParser.parseWinningNumbers(winningNumbers);

        assertThat(parsedWinningNumbers).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    void parseBonusNumber() {
        String bonusNumber = "12";
        int parsedBonusNumber = inputParser.parseBonusNumber(bonusNumber);

        assertThat(parsedBonusNumber).isEqualTo(12);
    }
}