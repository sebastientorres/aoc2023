package day;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Nine extends Solution<Integer, Integer> {
    public static final int DAY = 9;

    protected int findNextInSequence(String input) {
        Integer[] sequence = Arrays.stream(input.split(" "))
                .map(i -> Integer.valueOf(i.trim()))
                .collect(Collectors.toList()).toArray(new Integer[0]);

        return findNextInSequence(sequence, sequence[sequence.length-1], false);
    }

    protected int findNextInSequence(Integer[] sequence, int sum, boolean areAllElementsZero) {
        if (areAllElementsZero) {
            return sum;
        }
        Integer[] differences = findDifferences(sequence);
        sum += differences[differences.length-1];

        return findNextInSequence(differences, sum, areAllElementsZero(differences));
    }

    boolean areAllElementsZero(Integer[] input) {
        return Arrays.stream(input).allMatch(e -> e == 0);
    }

    Integer[] findDifferences(Integer[] sequence) {
        Integer[] differences = new Integer[sequence.length-1];

        for (int i = 0; i < sequence.length-1; i++) {
            int a = sequence[i];
            int b = sequence[i+1];
            differences[i] = b - a;
        }
        return differences;
    }

    @Override
    public Integer partOne() {
        return getLines().stream().map(this::findNextInSequence).reduce(0, (a, b) -> a + b);
    }

    @Override
    public Integer partTwo() {
        return null;
    }

    @Override
    public int today() {
        return DAY;
    }
}
