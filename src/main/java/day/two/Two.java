package day.two;

import day.Solution;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@AllArgsConstructor
@NoArgsConstructor
public class Two implements Solution<Integer, Integer> {

    @Setter
    private File file;

    @Override
    public Integer partOne() {

        try {
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter("\n");

            var digits = new ArrayList<String>();

            while (scanner.hasNext()) {

            }
        } catch (FileNotFoundException e) {
            return -1;
        }

        return 100;
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
                    map.put(colour, previousCount + count);
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
