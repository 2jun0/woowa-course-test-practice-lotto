package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.util.RandomNumbersGenerator;

public class LottoSeller {

    private static final int LOTTO_PRICE = 1000;

    private final RandomNumbersGenerator randomNumbersGenerator;

    public LottoSeller(RandomNumbersGenerator randomNumbersGenerator) {
        this.randomNumbersGenerator = randomNumbersGenerator;
    }

    public List<Lotto> buyLottoList(int money) {
        int lottoCount = getLottoCount(money);

        return Stream.generate(this::generateLotto)
                .limit(lottoCount)
                .collect(Collectors.toList());
    }

    private Lotto generateLotto() {
        List<Integer> randomNumbers = randomNumbersGenerator.generate(
                Lotto.LOTTO_MIN_NUMBER_INCLUSIVE, Lotto.LOTTO_MAX_NUMBER_INCLUSIVE,
                Lotto.LOTTO_NUMBER_COUNT);
        return new Lotto(randomNumbers);
    }

    private int getLottoCount(int money) {
        return money / LOTTO_PRICE;
    }
}
