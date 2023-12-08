package day;

import day.Solution;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Four extends Solution<Integer, Integer> {

    public static final int DAY = 4;

    protected int pointsFromLine(String line) {
        int count = winningHandsFromLine(line);

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

    protected int winningHandsFromLine(String line ) {
        var tokens = line.trim().substring(line.indexOf(":")+2).split("\\|");

        var winningNumbers = Arrays.stream(tokens[0].trim().split(" ")).filter(t -> !t.isBlank()).collect(Collectors.toSet());
        var cardNumbers = Arrays.stream(tokens[1].trim().split(" ")).filter(t -> !t.isBlank()).collect(Collectors.toSet());

        winningNumbers.retainAll(cardNumbers);
        return winningNumbers.size();
    }

    protected List<String> wonGamesFromLine(String line) {
        var wonGames = new ArrayList<String>();

        var points = winningHandsFromLine(line);

        var gameIndex = extractGameIndex(line);

        for (int i = 0; i < points; i++) {
            if (i < getLines().size()) {
                wonGames.add(getLines().get(i + gameIndex));
            }
        }

        return wonGames;
    }

    @Override
    public Integer partOne() {
        return getLines().stream().map(this::pointsFromLine).reduce(0, (a, b) -> a + b);
    }

    @Override
    public Integer partTwo() {
        int sum = 0;

        Queue<String> wonGames = new ArrayDeque<>(getLines());

        sum = getLines().size();

        while (!wonGames.isEmpty()) {
            var game = wonGames.poll();
            var winnings = wonGamesFromLine(game);
            sum += winnings.size();
            wonGames.addAll(winnings);
        }

        return sum;
    }

    @Override
    public int today() {
        return DAY;
    }

    protected int extractGameIndex(String game) {
        return Integer.valueOf(
                Arrays.stream(game.split("\\:")[0].trim().split(" "))
                        .filter(t -> !t.isBlank())
                        .collect(Collectors.toList()).get(1).trim()
        );
    }
}
