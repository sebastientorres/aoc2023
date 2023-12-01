package day.one;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {

        String filePath = "src/main/resources/day/one/input";
        var solution = new Solution();
        System.out.println("solution.partOne() = " + solution.partOne(filePath));

    }

    int partOne(String filePath) {
        try {
            Scanner scanner = new Scanner(new File(filePath));
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

}
