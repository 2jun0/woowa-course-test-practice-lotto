package lotto.view;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoPrize;

public class OutputView {

    private final OutputFormatter outputFormatter;

    public OutputView(OutputFormatter outputFormatter) {
        this.outputFormatter = outputFormatter;
    }

    public void printPurchasedLottoList(List<Lotto> lottoList) {
        printLine("%d개를 구매했습니다.", lottoList.size());
        lottoList.forEach(this::printLottoNumbers);
        printEmptyLine();
    }

    private void printLottoNumbers(Lotto lotto) {
        String formattedLottoNumbers = outputFormatter.formatLottoNumbers(lotto);
        printLine(formattedLottoNumbers);
    }

    public void printWinningStatistics(List<LottoPrize> lottoPrizes, double yield) {
        printLine("당첨 통계");
        printLine("---");

        Arrays.stream(LottoPrize.values())
                .sorted(Collections.reverseOrder())
                .map(lottoPrize ->
                        outputFormatter.formatLottoPrizeStatistics(lottoPrize,
                                Collections.frequency(lottoPrizes, lottoPrize)))
                .forEach(this::printLine);
        printYield(yield);
    }

    public void printYield(double yield) {
        printLine("총 수익률은 %.1f%%입니다.", yield*100);
    }

    public void printError(String message) {
        printLine("[ERROR] %s", message);
    }

    public void printLine(String format, Object... args) {
        System.out.printf(format + "%n", args);
    }

    public void printEmptyLine() {
        System.out.println();
    }
}
