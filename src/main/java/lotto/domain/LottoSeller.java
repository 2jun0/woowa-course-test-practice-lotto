package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.util.RandomNumbersGenerator;

public class LottoSeller {

    public static final int LOTTO_PRICE = 1000;

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
        List<Integer> randomNumbers = randomNumbersGenerator.generate(1, 45, 6);
        return new Lotto(randomNumbers);
    }

    private int getLottoCount(int money) {
        return money / LOTTO_PRICE;
    }
}
