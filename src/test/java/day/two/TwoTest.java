package day.two;

import day.SolutionTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class TwoTest implements SolutionTest {

    @Override
    public String geDay() {
        return "2";
    }

    @Test
    void partOne() {
        File file = new File(getPath() + "/inputPartOne");
        var solution = new Two(file);
        assertEquals(8, solution.partOne());
    }


    @Test
    void possibleGames() {
        File file = new File(getPath() + "/inputPartOne");
        var solution = new Two(file);

        var games = new HashMap<Integer, Map<Two.Colour, Integer>>();
        games.put(1, partOneGame1());
        games.put(2, partOneGame2());
        games.put(3, partOneGame3());
        games.put(4, partOneGame4());
        games.put(5, partOneGame5());

        assertEquals(List.of(1, 2, 5), solution.indexOfGamesThatArePossible(games));
    }

    @ParameterizedTest
    @MethodSource
    void partOneLineParser(String line, Map<Two.Colour, Integer> colourCount) {
        Two solution = new Two();

        var actual = solution.partOneLineParser(line);

        assertEquals(colourCount, actual);
    }

    @ParameterizedTest
    @MethodSource
    void partTwoLineParser(String line, Map<Two.Colour, Integer> colourCount) {
        Two solution = new Two();

        var actual = solution.partTwoLineParser(line);

        assertEquals(colourCount, actual);
    }

    private static String game1 = "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green";
    private static String game2 = "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue";
    private static String game3 = "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red";
    private static String game4 = "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red";
    private static String game5 = "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green";

    static Stream<Arguments> partOneLineParser() {
        return Stream.of(
                arguments(
                        game1,
                        partOneGame1()
                ),
                arguments(
                        game2,
                        partOneGame2()
                ),
                arguments(
                       game3,
                        partOneGame3()
                ),
                arguments(
                        game4,
                        partOneGame4()
                ),
                arguments(
                       game5,
                        partOneGame5()
                )
        );
    }

    static Map<Two.Colour, Integer> partOneGame1() {
        var map = new HashMap<Two.Colour, Integer>();
        map.put(Two.Colour.blue, 6);
        map.put(Two.Colour.red, 4);
        map.put(Two.Colour.green, 2);
        return map;
    }

    static Map<Two.Colour, Integer> partOneGame2() {
        var map = new HashMap<Two.Colour, Integer>();
        map.put(Two.Colour.blue, 4);
        map.put(Two.Colour.red, 1);
        map.put(Two.Colour.green, 3);
        return map;
    }

    static Map<Two.Colour, Integer> partOneGame3() {
        var map = new HashMap<Two.Colour, Integer>();
        map.put(Two.Colour.blue, 6);
        map.put(Two.Colour.red, 20);
        map.put(Two.Colour.green, 13);
        return map;
    }

    static Map<Two.Colour, Integer> partOneGame4() {
        var map = new HashMap<Two.Colour, Integer>();
        map.put(Two.Colour.blue, 15);
        map.put(Two.Colour.red, 14);
        map.put(Two.Colour.green, 3);
        return map;
    }

    static Map<Two.Colour, Integer> partOneGame5() {
        var map = new HashMap<Two.Colour, Integer>();
        map.put(Two.Colour.blue, 2);
        map.put(Two.Colour.red, 6);
        map.put(Two.Colour.green, 3);
        return map;
    }

    static Stream<Arguments> partTwoLineParser() {
        return Stream.of(
                arguments(
                        game1,
                        partTwoGame1()
                ),
                arguments(
                        game2,
                        partTwoGame2()
                ),
                arguments(
                        game3,
                        partTwoGame3()
                ),
                arguments(
                        game4,
                        partTwoGame4()
                ),
                arguments(
                        game5,
                        partTwoGame5()
                )
        );
    }

    static Map<Two.Colour, Integer> partTwoGame1() {
        return Map.of(
                Two.Colour.blue, 3,
                Two.Colour.red, 1,
                Two.Colour.green, 2
        );
    }

    static Map<Two.Colour, Integer> partTwoGame2() {
        return Map.of(
                Two.Colour.blue, 1,
                Two.Colour.red, 1,
                Two.Colour.green, 1
        );
    }

    static Map<Two.Colour, Integer> partTwoGame3() {
        return Map.of(
                Two.Colour.blue, 5,
                Two.Colour.red, 1,
                Two.Colour.green, 5
        );
    }

    static Map<Two.Colour, Integer> partTwoGame4() {
        return Map.of(
                Two.Colour.blue, 6,
                Two.Colour.red, 3,
                Two.Colour.green, 1
        );
    }

    static Map<Two.Colour, Integer> partTwoGame5() {
        return Map.of(
                Two.Colour.blue, 1,
                Two.Colour.red, 1,
                Two.Colour.green, 2
        );
    }


}