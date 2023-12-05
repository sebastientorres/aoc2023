package day;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.BinaryOperator;

@NoArgsConstructor
@Service(One.DAY)
public class One extends AbstractSolution implements Solution<Integer, Integer> {

    static final String DAY = "1";

    private final static BinaryOperator<Integer> integerAccumulator = (a, b) -> a + b;
    private final static BinaryOperator<String> stringAccumulator = (a, b) -> a + b;

    @Override
    public Integer partOne() {

        var digits = new ArrayList<String>();
        getLines().forEach(l -> digits.add(Arrays.stream(l.split(""))
                .filter(t -> t.matches("\\d"))
                .reduce("", stringAccumulator))
        );

        return digits.stream()
                .map(this::partOneLineDecoder)
                .reduce(0, integerAccumulator);

    }

    @Override
    public Integer partTwo() {
        List<Integer> integers = new ArrayList<>();

        getLines().stream().forEach(l -> integers.add(partTwoLineDecoder(l)));
        return integers.stream().reduce(0, integerAccumulator);
    }

    int partOneLineDecoder(String input) {
        var digits = Arrays.stream(input.split(""))
                .filter(t -> t.matches("\\d"))
                .reduce(stringAccumulator).get();

        var result = "";

        if (digits.length() == 1) {
            result = digits + digits;
        } else if (digits.length() > 2) {
            result = digits.substring(0, 1) + digits.substring(digits.length() - 1, digits.length());

        } else {
            result = digits;
        }

        return Integer.valueOf(result);
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

    @Override
    public int getDay() {
        return Integer.valueOf(DAY);
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
