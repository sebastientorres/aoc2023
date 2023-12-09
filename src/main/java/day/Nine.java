package day;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Nine extends Solution<Integer, Integer> {
    public static final int DAY = 9;

    protected int findNextInSequence(String input) {
        Integer[] sequence = Arrays.stream(input.split(" "))
                .map(i -> Integer.valueOf(i.trim()))
                .collect(Collectors.toList()).toArray(new Integer[0]);

        int sum = 0;

        Integer[] differences = findDifferences(sequence);

        while(differences[differences.length - 1] > 0) {
            sum += differences[differences.length-1];
            differences = findDifferences(differences);
        }

        return sum + sequence[sequence.length-1];
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
        return null;
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
