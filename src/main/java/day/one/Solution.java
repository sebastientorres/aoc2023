package day.one;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {

        File file = new File("src/main/resources/day/one/input");
        var solution = new Solution();
        System.out.println("solution.partOne() = " + solution.partOne(file));
        System.out.println("solution.partTwo(file) = " + solution.partTwo(file));

    }

    int partOne(File file) {
        try {
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter("\n");

            var digits = new ArrayList<String>();

            while (scanner.hasNext()) {

                var next = scanner.next();
                var s = Arrays.stream(next.split(""))
                        .filter(t -> t.matches("\\d"))
                        .collect(Collectors.joining(""));
                digits.add(s);
            }

            return digits.stream()
                    .map(this::partOneLineDecoder)
                    .reduce(0, (subtotal, element) -> subtotal + element);

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

            return integers.stream().reduce(0, (subtotal, element) -> subtotal + element);

        } catch (Exception e) {
            return -1;
        }
    }

    int partTwoLineDecoder(String line) {

        String finalLine = line;
        var numbersContainedInLine = Arrays.stream(Number.values())
                .collect(Collectors.toMap(Number::name, (n) -> finalLine.contains(n.name())))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue())
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());

        var sortedIndexes = numbersContainedInLine
                .stream()
                .collect(Collectors.toMap((n) -> finalLine.indexOf(n), (n) -> n))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        for(Map.Entry<Integer, String> entry : sortedIndexes.entrySet()) {
            line = line.replace(entry.getValue(), Number.valueOf(entry.getValue()).value);
        }

        return partOneLineDecoder(line);
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
