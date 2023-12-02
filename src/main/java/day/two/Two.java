package day.two;

import day.Solution;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

import static day.two.Two.Colour.*;

@AllArgsConstructor
@NoArgsConstructor
public class Two implements Solution<Integer, Integer> {

    @Setter
    private File file;

    private final Map<Colour, Integer> maxCounts = Map.of(
            red, 12,
            green, 13,
            blue, 14
    );

    @Override
    public Integer partOne() {

        var games = new HashMap<Integer, Map<Colour, Integer>>();
        try {
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter("\n");

            while (scanner.hasNext()) {
                var game = scanner.next();
                var gameIndex = Integer.valueOf(game.split(":")[0].split(" ")[1]);

                games.put(gameIndex, partOneLineParser(game));
            }

        } catch (FileNotFoundException e) {
            return -1;
        }

        return sumGamesThatWork(games);
    }

    List<Integer> indexOfGamesThatArePossible(Map<Integer, Map<Colour, Integer>> games) {
        return games
                .entrySet()
                .stream()
                .filter(entry -> {
                    var map = entry.getValue();

                    var r = map.get(red);
                    var g = map.get(green);
                    var b = map.get(blue);

                    if (null == r) {
                        r = 0;
                    }

                    if (null == g) {
                        g = 0;
                    }

                    if (null == b) {
                        b = 0;
                    }

                    return map.get(red) < maxCounts.get(red)
                            && map.get(green) < maxCounts.get(green)
                            &&  map.get(blue) < maxCounts.get(blue);
                })
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());
    }

    int sumGamesThatWork(HashMap<Integer, Map<Colour, Integer>> games) {
        return games
                .entrySet()
                .stream()
                .filter(entry -> {
                    var map = entry.getValue();

                    return map.get(red) <= maxCounts.get(red)
                            && map.get(green) <= maxCounts.get(green)
                            &&  map.get(blue) <= maxCounts.get(blue);
                })
                .map(entry -> entry.getKey())
                .reduce(0, (a, b) -> a + b);
    }

    @Override
    public Integer partTwo() {
        return -2;
    }

    private static BiFunction<Integer, Integer, Integer> max = (a, b) -> a <= b ? b : a;
    private static BiFunction<Integer, Integer, Integer> min = (a, b) -> a <= b ? a : b;

    public Map<Colour, Integer> partOneLineParser(String line) {
        return lineParserWithFunction(line, max);
    }

    public  Map<Colour, Integer> partTwoLineParser(String line) {
        return lineParserWithFunction(line, min);
    }

    public Map<Colour, Integer> lineParserWithFunction(String line, BiFunction<Integer, Integer, Integer> fn) {
        var map = new HashMap<Colour, Integer>();

        var indexOfColon = line.indexOf(":");
        var draws = line.substring(indexOfColon + 1, line.length()).split(";");

        for (int i = 0; i < draws.length; i++) {
            var draw = draws[i];
            var groups = draw.split(",");

            for (int j = 0; j < groups.length; j++) {
                var group = groups[j].trim().split(" ");
                var colour = Colour.valueOf(group[1]);
                var count = Integer.valueOf(group[0]);
                if (map.containsKey(colour)) {
                    int previousCount = map.get(colour);
                    map.put(colour, fn.apply(previousCount, count));
                } else {
                    map.put(colour, count);
                }
            }
        }

        return map;
    }

    enum Colour {
        blue,
        red,
        green;
    }
}
