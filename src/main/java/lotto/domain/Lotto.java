package lotto.domain;

import java.util.List;

public class Lotto {

    static final int LOTTO_NUMBER_COUNT = 6;
    static final int LOTTO_MIN_NUMBER_INCLUSIVE = 1;
    static final int LOTTO_MAX_NUMBER_INCLUSIVE = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    boolean contains(int number) {
        return numbers.contains(number);
    }

    public List<Integer> numbers() {
        return numbers;
    }
}
