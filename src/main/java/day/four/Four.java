package day.four;

import day.Solution;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.File;
import java.util.Arrays;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
public class Four implements Solution<Integer, Integer> {

    private File file;

    protected int pointsFromLine(String line) {

        var tokens = line.substring(line.indexOf(":")+1).split("\\|");

        var winningNumbers = Arrays.stream(tokens[0].trim().split(" ")).collect(Collectors.toSet());
        var cardNumbers = Arrays.stream(tokens[1].trim().split(" ")).collect(Collectors.toSet());

        int count = Math.toIntExact(cardNumbers.stream().filter(c -> winningNumbers.contains(c))
                .count());

        if (count < 2) {
            return count;
        } else {
            int score = 1;

            for (int i = 2 ; i <= count ; i++) {
                score *= 2;
            }

            return score;
        }

    }

    @Override
    public Integer partOne() {
        return null;
    }

    @Override
    public Integer partTwo() {
        return null;
    }
}
