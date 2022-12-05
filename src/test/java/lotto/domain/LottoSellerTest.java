package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.util.RandomNumbersGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoSellerTest {

    LottoSeller lottoSeller;

    @BeforeEach
    public void initializeLottoSeller() {
        lottoSeller = new LottoSeller(new RandomNumbersGenerator());
    }

    @Nested
    class BuyLottoListTest {

        @ParameterizedTest(name = "failWithInvalidMoney {argumentsWithNames}")
        @ValueSource(ints = {0, -1000, 999})
        void failWithInvalidMoney(int money) {
            assertThatThrownBy(() -> lottoSeller.buyLottoList(money))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest(name = "success {argumentsWithNames}")
        @CsvSource({"3000, 3", "1000, 1"})
        void success(int money, int size) {
            List<Lotto> lottoList = lottoSeller.buyLottoList(money);

            assertThat(lottoList.size())
                    .isEqualTo(size);
        }
    }
}