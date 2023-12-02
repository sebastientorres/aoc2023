package day.two;

import day.SolutionTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.util.HashMap;
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

    @ParameterizedTest
    @MethodSource
    void partOneLineParser(String line, Map<Two.Colour, Integer> colourCount) {
        Two solution = new Two();

        var actual = solution.partOneLineParser(line);

        assertEquals(colourCount, actual);
    }

    static Stream<Arguments> partOneLineParser() {
        return Stream.of(
                arguments(
                        "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green",
                        game1()
                ),
                arguments(
                        "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue",
                        game2()
                ),
                arguments(
                        "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red",
                        game3()
                ),
                arguments(
                        "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red",
                        game4()
                ),
                arguments(
                        "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green",
                        game5()
                )
        );
    }

    static Map<Two.Colour, Integer> game1() {
        var map = new HashMap<Two.Colour, Integer>();
        map.put(Two.Colour.blue, 9);
        map.put(Two.Colour.red, 5);
        map.put(Two.Colour.green, 4);
        return map;
    }

    static Map<Two.Colour, Integer> game2() {
        var map = new HashMap<Two.Colour, Integer>();
        map.put(Two.Colour.blue, 6);
        map.put(Two.Colour.red, 1);
        map.put(Two.Colour.green, 6);
        return map;
    }

    static Map<Two.Colour, Integer> game3() {
        var map = new HashMap<Two.Colour, Integer>();
        map.put(Two.Colour.blue, 11);
        map.put(Two.Colour.red, 25);
        map.put(Two.Colour.green, 26);
        return map;
    }

    static Map<Two.Colour, Integer> game4() {
        var map = new HashMap<Two.Colour, Integer>();
        map.put(Two.Colour.blue, 21);
        map.put(Two.Colour.red, 23);
        map.put(Two.Colour.green, 7);
        return map;
    }

    static Map<Two.Colour, Integer> game5() {
        var map = new HashMap<Two.Colour, Integer>();
        map.put(Two.Colour.blue, 3);
        map.put(Two.Colour.red, 7);
        map.put(Two.Colour.green, 5);
        return map;
    }

}