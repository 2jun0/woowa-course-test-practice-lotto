package lotto;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoPrize;
import lotto.domain.LottoSeller;
import lotto.domain.WinningNumberSet;
import lotto.domain.WinningNumbers;
import lotto.domain.YieldCalculator;
import lotto.util.RandomNumbersGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameMachine {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoGameMachine(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        try {
            playGame();
        } catch (IllegalArgumentException exception) {
            outputView.printError(exception.getMessage());
        }
    }

    private void playGame() {
        int purchaseMoney = inputLottoPurchaseMoney();
        List<Lotto> lottoList = buyLottoList(purchaseMoney);

        WinningNumberSet winningNumberSet = inputWinningNumberSet();

        List<LottoPrize> lottoPrizes = matchLottoListWithWinningNumberSet(
                lottoList, winningNumberSet);

        double yield = calculateYield(lottoPrizes, purchaseMoney);
        outputView.printWinningStatistics(lottoPrizes, yield);
    }

    private int inputLottoPurchaseMoney() {
        return inputView.inputLottoPurchaseMoney();
    }

    private List<Lotto> buyLottoList(int lottoPurchaseMoney) {
        LottoSeller lottoSeller = new LottoSeller(new RandomNumbersGenerator());

        List<Lotto> lottoList = lottoSeller.buyLottoList(lottoPurchaseMoney);
        outputView.printPurchasedLottoList(lottoList);

        return lottoList;
    }

    private WinningNumberSet inputWinningNumberSet() {
        WinningNumbers winningNumbers = inputWinningNumbers();
        BonusNumber bonusNumber = inputBonusNumber();

        return new WinningNumberSet(winningNumbers, bonusNumber);
    }

    private WinningNumbers inputWinningNumbers() {
        List<Integer> winningNumbers = inputView.inputWinningNumbers();
        return new WinningNumbers(winningNumbers);
    }

    private BonusNumber inputBonusNumber() {
        int bonusNumber = inputView.inputBonusNumber();
        return new BonusNumber(bonusNumber);
    }

    private List<LottoPrize> matchLottoListWithWinningNumberSet(
            List<Lotto> lottoList, WinningNumberSet winningNumberSet) {
        return lottoList.stream()
                .map(winningNumberSet::match)
                .filter(Objects::nonNull)
                .collect(Collectors.toUnmodifiableList());
    }

    private double calculateYield(List<LottoPrize> lottoPrizes, int purchaseMoney) {
        YieldCalculator yieldCalculator = new YieldCalculator();
        return yieldCalculator.yield(lottoPrizes, purchaseMoney);
    }
}
