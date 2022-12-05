package lotto.domain;

import java.util.List;

public class Lotto {

    static final int LOTTO_NUMBER_COUNT = 6;
    static final int LOTTO_MIN_NUMBER_INCLUSIVE = 1;
    static final int LOTTO_MAX_NUMBER_INCLUSIVE = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoNumberSize(numbers);
        validateLottoNumbersRange(numbers);

        this.numbers = numbers;
    }

    private void validateLottoNumberSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(
                    String.format("로또 번호의 개수는 %d개여야 합니다.", LOTTO_NUMBER_COUNT));
        }
    }

    private void validateLottoNumbersRange(List<Integer> numbers) {
        numbers.forEach(this::validateLottoNumberRange);
    }

    private void validateLottoNumberRange(int number) {
        if (!(LOTTO_MIN_NUMBER_INCLUSIVE <= number && number <= LOTTO_MAX_NUMBER_INCLUSIVE)) {
            throw new IllegalArgumentException(String.format("로또 번호는 %d부터 %d까지 여야 합니다.",
                    LOTTO_MIN_NUMBER_INCLUSIVE, LOTTO_MAX_NUMBER_INCLUSIVE));
        }
    }

    boolean contains(int number) {
        return numbers.contains(number);
    }

    public List<Integer> numbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "numbers=" + numbers +
                '}';
    }
}
