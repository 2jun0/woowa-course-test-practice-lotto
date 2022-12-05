package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningNumbersTest {

    @Nested
    @TestInstance(Lifecycle.PER_CLASS)
    class CreateTest {

        @ParameterizedTest(name = "failWithInvalidSize {argumentsWithNames}")
        @MethodSource("provideFailWithInvalidSize")
        void failWithInvalidSize(List<Integer> list) {
            assertThatThrownBy(() -> new WinningNumbers(list))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("당첨번호의 개수는 6여야 합니다.");
        }

        Stream<Arguments> provideFailWithInvalidSize() {
            return Stream.of(
                    Arguments.of(List.of(1, 2, 3, 4, 5)),
                    Arguments.of(List.of(1, 2, 3, 4, 5, 6, 7)));
        }

        @ParameterizedTest(name = "failWithDuplicateNumbers {argumentsWithNames}")
        @MethodSource("provideFailWithDuplicateNumbers")
        void failWithDuplicateNumbers(List<Integer> list) {
            assertThatThrownBy(() -> new WinningNumbers(list))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("당첨번호는 중복된 숫자가 들어가면 안됩니다.");
        }

        Stream<Arguments> provideFailWithDuplicateNumbers() {
            return Stream.of(
                    Arguments.of(List.of(1, 2, 3, 4, 5, 5)),
                    Arguments.of(List.of(1, 2, 3, 1, 5, 6)));
        }

        @ParameterizedTest(name = "failWithInvalidRange {argumentsWithNames}")
        @MethodSource("provideFailWithInvalidRange")
        void failWithInvalidRange(List<Integer> list) {
            assertThatThrownBy(() -> new WinningNumbers(list))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("당첨번호는 1부터 45사이의 정수여야 합니다.");
        }

        Stream<Arguments> provideFailWithInvalidRange() {
            return Stream.of(
                    Arguments.of(List.of(0, 2, 3, 4, 5, 6)),
                    Arguments.of(List.of(1, 2, 3, 4, 5, 46)));
        }
    }

    @ParameterizedTest(name = "matchCount {argumentsWithNames}")
    @MethodSource("provideMatchCount")
    void matchCount(List<Integer> list, Lotto lotto, int expect) {
        WinningNumbers winningNumbers = new WinningNumbers(list);
        int matchCount = winningNumbers.matchCount(lotto);

        assertThat(matchCount).isEqualTo(expect);
    }

    static Stream<Arguments> provideMatchCount() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6),
                        new Lotto(List.of(1, 2, 3, 45, 44, 43)), 3),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6),
                        new Lotto(List.of(45, 44, 43, 42, 41, 40)), 0),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6),
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)), 6));
    }
}