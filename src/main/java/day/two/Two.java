package day.two;

import day.Solution;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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

    int sumGamesThatWork(HashMap<Integer, Map<Colour, Integer>> games) {
        int sum = 0;

        for (Map.Entry<Integer, Map<Colour, Integer>> entry : games.entrySet()) {
            var map = entry.getValue();

            if (map.get(red) < maxCounts.get(red)
                    && map.get(green) < maxCounts.get(green)
                    &&  map.get(blue) < maxCounts.get(blue)) {
                sum += entry.getKey();
            }

        }

        return sum;
    }

    @Override
    public Integer partTwo() {
        return -2;
    }

    public Map<Colour, Integer> partOneLineParser(String line) {
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
                    var value = previousCount < count ? count : previousCount;
                    map.put(colour, value);
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
