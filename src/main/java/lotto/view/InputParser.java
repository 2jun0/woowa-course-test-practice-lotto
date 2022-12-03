package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {

    public static final String WINNING_NUMBERS_DELIMITER = ",";

    public int parseLottoPurchaseMoney(String lottoPurchaseMoney) {
        return Integer.parseInt(lottoPurchaseMoney);
    }

    public List<Integer> parseWinningNumbers(String winningNumbers) {
        return Arrays.stream(winningNumbers.split(WINNING_NUMBERS_DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int parseBonusNumber(String bonusNumber) {
        return Integer.parseInt(bonusNumber);
    }
}
