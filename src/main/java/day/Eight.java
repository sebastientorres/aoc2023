package day;

import lombok.AccessLevel;
import lombok.Setter;

import java.util.*;
import java.util.stream.Collectors;

public class Eight extends Solution<Integer, Integer> {

    public static final int DAY = 8;

    @Setter(AccessLevel.PROTECTED)
    private String directions;
    private final Map<String, String> map = new HashMap<>();

    @Override
    public Integer partOne() {
        var directions = getLines().get(0);

        map.putAll(lineParser(getLines()));

        var start = map.get("AAA");

        int counter = 0;
        int directionCounter = 0;
        boolean notFound = true;
        var directionArray = directions.split("");

        var next = map.get("AAA");
        var direction = directionArray[directionCounter];
        while(notFound) {
            direction = directionArray[directionCounter];
            var lr = direction.equals("L") ? 0 : 1;
            var d = next.split(",")[lr].trim();
            next = map.get(d);
            counter++;
            directionCounter++;
            if (directionCounter == directionArray.length) {
                directionCounter = 0;
            }
            notFound = !next.equals("ZZZ, ZZZ");
        }

        return counter;
    }

    protected Map<String, String> lineParser(List<String> lines) {
        return lines.stream().filter(l -> !l.equals(directions) && !l.isBlank())
                .collect(Collectors.toMap(
                        l -> l.split("=")[0].trim(),
                        l -> l.split("=")[1].trim().replace("(", "").replace(")", ""))
                );
    }

    @Override
    public Integer partTwo() {
        return null;
    }

    @Override
    public int today() {
        return DAY;
    }
}
