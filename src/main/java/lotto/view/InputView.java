package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {

    private final InputParser inputParser;
    private final InputValidator inputValidator;

    public InputView(InputParser inputParser, InputValidator inputValidator) {
        this.inputParser = inputParser;
        this.inputValidator = inputValidator;
    }

    public int inputLottoPurchaseMoney() {
        printLine("구입금액을 입력해 주세요.");
        String lottoPurchaseMoney = readLine();
        printEmptyLine();

        inputValidator.validateLottoPurchaseMoney(lottoPurchaseMoney);
        return inputParser.parseLottoPurchaseMoney(lottoPurchaseMoney);
    }

    public List<Integer> inputWinningNumbers() {
        printLine("당청 번호를 입력해 주세요.");
        String winningNumbers = readLine();
        printEmptyLine();

        inputValidator.validateWinningNumbers(winningNumbers);
        return inputParser.parseWinningNumbers(winningNumbers);
    }

    public int inputBonusNumber() {
        printLine("보너스 번호를 입력해 주세요.");
        String bonusNumber = readLine();
        printEmptyLine();

        inputValidator.validateBonusNumber(bonusNumber);
        return inputParser.parseBonusNumber(bonusNumber);
    }

    private String readLine() {
        return Console.readLine().trim();
    }

    private void printLine(String s) {
        System.out.println(s);
    }

    private void printEmptyLine() {
        System.out.println();
    }
}
