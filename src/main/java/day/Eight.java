package day;

import lombok.AccessLevel;
import lombok.Setter;

import java.util.*;
import java.util.stream.Collectors;

public class Eight extends Solution<Integer, Integer> {

    public static final int DAY = 8;

    @Setter(AccessLevel.PROTECTED)
    private String directions;
    private final Map<String, MapEntry> map = new HashMap<>();

    @Override
    public Integer partOne() {
        var directions = getLines().get(0);

        setDirections(getLines().get(0));
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
            var isLeft = direction.equals("L");
            var d = isLeft ? next.getLeft() : next.getRight();
            next = map.get(d);
            counter++;
            directionCounter++;
            if (directionCounter == directionArray.length) {
                directionCounter = 0;
            }
            notFound = !next.getLocation().equals("ZZZ");
        }

        return counter;
    }

    protected Map<String, MapEntry> lineParser(List<String> lines) {
        return lines.stream().filter(l -> !l.equals(directions) && !l.isBlank())
                .collect(Collectors.toMap(
                        l -> l.split("=")[0].trim(),
                        l -> {
                            var location = l.split("=")[0].trim();
                            var lr = l.split("=")[1].trim().replace("(", "").replace(")", "").trim();
                            var left = lr.split(",")[0].trim();
                            var right = lr.split(",")[1].trim();
                            return new MapEntry(location, left, right);
                        })
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
