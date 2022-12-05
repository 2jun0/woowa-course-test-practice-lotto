package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BonusNumberTest {

    @DisplayName("보너스 번호가 1~45의 값이 아니면 예외가 발생한다.")
    @Test
    void createBonusNumberByInvalidNumber() {
        assertThatThrownBy(() -> new BonusNumber(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "match {argumentsWithNames}")
    @MethodSource("provideMatch")
    void match(BonusNumber bonusNumber, Lotto lotto, boolean expect) {
        boolean match = bonusNumber.match(lotto);
        assertThat(match).isEqualTo(expect);
    }

    static Stream<Arguments> provideMatch() {
        return Stream.of(
                Arguments.of(
                        new BonusNumber(5),
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        true),
                Arguments.of(
                        new BonusNumber(7),
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        false));
    }
}