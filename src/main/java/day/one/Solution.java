package day.one;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {

        File file = new File("src/main/resources/day/one/input");
        var solution = new Solution();
        System.out.println("solution.partOne() = " + solution.partOne(file));
        System.out.println("solution.partTwo(file) = " + solution.partTwo(file));

    }

    private final static BinaryOperator<Integer> integerAccumulator = (a, b) -> a + b;
    private final static BinaryOperator<String> stringAccumulator = (a, b) -> a + b;

    int partOne(File file) {
        try {
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter("\n");

            var digits = new ArrayList<String>();

            while (scanner.hasNext()) {

                var next = scanner.next();
                var s = Arrays.stream(next.split(""))
                        .filter(t -> t.matches("\\d"))
                        .reduce("", stringAccumulator);
                digits.add(s);
            }

            return digits.stream()
                    .map(this::partOneLineDecoder)
                    .reduce(0, integerAccumulator);

        } catch (FileNotFoundException e) {
            return -1;
        }
    }

    int partOneLineDecoder(String input) {
        var digits = Arrays.stream(input.split(""))
                .filter(t -> t.matches("\\d"))
                .collect(Collectors.joining());

        if (digits.length() == 1) {
            return Integer.valueOf(digits+digits);
        } else if (digits.length() > 2) {
            return Integer.valueOf(digits.substring(0, 1) + digits.substring(digits.length() - 1, digits.length()));

        } else {
            return Integer.valueOf(digits);
        }

    }

    int partTwo(File file) {
        try {
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter("\n");

            List<Integer> integers = new ArrayList<>();

            while (scanner.hasNext()) {
                var line = scanner.next();
                integers.add(partTwoLineDecoder(line));
            }

            return integers.stream().reduce(0, integerAccumulator);

        } catch (Exception e) {
            return -1;
        }
    }

    int partTwoLineDecoder(String line) {
        String[] numbers = new String[line.length()];

        var tokens = line.split("");

        for (Number n : Number.values()) {
            if (line.contains(n.name())) {
                numbers[line.indexOf(n.name())] = n.value;
            }
        }

        for (int i = 0; i < line.length(); i++) {
            var t = tokens[i];
            if (t.matches("\\d")) {
                numbers[i] = t;
            }
        }

        var thing = Arrays.stream(numbers).reduce("", stringAccumulator);

        return partOneLineDecoder(thing);
    }

    enum Number {
        one("1"),
        two("2"),
        three("3"),
        four("4"),
        five("5"),
        six("6"),
        seven("7"),
        eight("8"),
        nine("9");

        private final String value;

        Number(String value) {
            this.value = value;
        }

    }

}
