package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {

    private final OutputFormatter outputFormatter;

    public OutputView(OutputFormatter outputFormatter) {
        this.outputFormatter = outputFormatter;
    }

    public void printPurchasedLottoList(List<Lotto> lottoList) {
        printLine("%d개를 구매했습니다.");
        lottoList.forEach(this::printLottoNumbers);
        printEmptyLine();
    }

    private void printLottoNumbers(Lotto lotto) {
        String formattedLottoNumbers = outputFormatter.formatLottoNumbers(lotto);
        printLine(formattedLottoNumbers);
    }

    public void printLine(String format, Object ...args) {
        System.out.printf(format+"%n", args);
    }

    public void printEmptyLine() {
        System.out.println();
    }
}
