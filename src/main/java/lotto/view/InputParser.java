package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {

    static final String WINNING_NUMBERS_DELIMITER = ",";

    int parseLottoPurchaseMoney(String lottoPurchaseMoney) {
        return Integer.parseInt(lottoPurchaseMoney);
    }

    List<Integer> parseWinningNumbers(String winningNumbers) {
        return Arrays.stream(winningNumbers.split(WINNING_NUMBERS_DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    int parseBonusNumber(String bonusNumber) {
        return Integer.parseInt(bonusNumber);
    }
}
