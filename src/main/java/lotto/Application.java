package lotto;

import lotto.view.InputParser;
import lotto.view.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputFormatter;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoGameMachine lottoGameMachine = new LottoGameMachine(
                new InputView(new InputParser(), new InputValidator()),
                new OutputView(new OutputFormatter()));

        lottoGameMachine.start();
    }
}
