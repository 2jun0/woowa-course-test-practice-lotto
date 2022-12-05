package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoPrize;
import lotto.domain.WinningResults;

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

    public void printWinningStatistics(WinningResults results, double yield) {
        printLine("당첨 통계");
        printLine("---");

        printLottoPrizesCount(results.countOfPrize());
        printYield(yield);
    }

    private void printLottoPrizesCount(Map<LottoPrize, Integer> countOfPrize) {
        for (LottoPrize lottoPrize : LottoPrize.values()) {
            String formattedLottoPrizeCount = outputFormatter.formatLottoPrizeCount(
                    lottoPrize, countOfPrize.get(lottoPrize));
            printLine(formattedLottoPrizeCount);
        }
    }

    public void printYield(double yield) {
        printLine("총 수익률은 %.1f%%입니다.", yield * 100);
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
