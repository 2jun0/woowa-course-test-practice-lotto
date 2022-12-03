package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {

    private final InputParser inputParser;

    public InputView(InputParser inputParser) {
        this.inputParser = inputParser;
    }

    public int inputLottoPrice() {
        printLine("구입금액을 입력해 주세요.");
        String lottoPrice = Console.readLine();
        printEmptyLine();

        return inputParser.parseLottoPrice(lottoPrice);
    }

    public List<Integer> inputWinningNumbers() {
        printLine("당청 번호를 입력해 주세요.");
        String winningNumbers = Console.readLine();
        printEmptyLine();

        return inputParser.parseWinningNumbers(winningNumbers);
    }

    private void printLine(String s) {
        System.out.println(s);
    }

    private void printEmptyLine() {
        System.out.println();
    }
}
