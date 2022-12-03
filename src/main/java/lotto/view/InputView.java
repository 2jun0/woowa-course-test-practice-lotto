package lotto.view;

import camp.nextstep.edu.missionutils.Console;

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

    private void printLine(String s) {
        System.out.println(s);
    }

    private void printEmptyLine() {
        System.out.println();
    }
}
