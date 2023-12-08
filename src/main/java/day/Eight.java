package day;

import lombok.AccessLevel;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Eight extends Solution<Integer, Integer> {

    public static final int DAY = 8;

    @Setter(AccessLevel.PROTECTED)
    private String directions;
    private final Map<String, String> map = new HashMap<>();

    @Override
    public Integer partOne() {
        var directions = getLines().get(0);

        map.putAll(getLines().stream()
                .filter(l -> !directions.equals(directions))
                .collect(Collectors.toMap(
                        l -> l.split("\\+")[0].trim(),
                        l -> l.split("\\+")[1].trim()
                        )
                )
        );

        var start = map.get("AAA");

        int counter = 0;
        boolean notFound = true;
        while(notFound) {


        }

        return counter;
    }

    protected Map<String, String> lineParser(List<String> lines) {
        return lines.stream().filter(l -> !l.equals(directions) && !l.isBlank())
                .collect(Collectors.toMap(
                        l -> l.split("=")[0].trim(),
                        l -> l.split("=")[1].trim())
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
