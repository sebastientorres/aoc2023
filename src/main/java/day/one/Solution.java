package day.one;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
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

            var result = digits.stream()
                    .map(s -> {
                        if (s.length() == 1) {
                            return s+s;
                        } else if (s.length() > 2) {
                            return s.substring(0, 1) + s.substring(s.length() - 1, s.length());

                        } else {
                            return s;
                        }
                    })
                    .mapToInt(Integer::parseInt)
                    .sum();
            return result;

        } catch (FileNotFoundException e) {
            return -1;
        }
    }

    int partTwo(File file) {
        try {
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter("\n");

            while (scanner.hasNext()) {

                List<Integer> indexes = new ArrayList<>();

                var line = scanner.next();

                for (Number n : Number.values()) {
                    if (line.contains(n.name())) {

                    }
                }

            }

        } catch (Exception e) {
            return -1;
        }

        return -1;
    }

    enum Number {
        one(1),
        two(2),
        three(3),
        four(4),
        five(5),
        six(6),
        seven(7),
        eight(8),
        nine(9);

        private final int value;

        Number(int value) {
            this.value = value;
        }
    }

}