package day.one;

import day.Solution;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

class OneTest {

    private static final String path = "src/test/resources/day/one";

    @Test
    public void partOne() {
        var file = new File(path+"/inputPartOne");
        Solution solution = new One(file);
        var actual = solution.partOne();
        assertEquals(142, actual);
    }

    @ParameterizedTest
    @MethodSource
    void partOneLineDecoder(String input, int expected) {
        var one = new One();
        assertEquals(expected, one.partOneLineDecoder(input));
    }

    @Test
    public void partTwo() {
        var file = new File(path+"/inputPartTwo");
        Solution solution = new One(file);
        var actual = solution.partTwo();
        assertEquals(281, actual);
    }

    @ParameterizedTest
    @MethodSource
    void partTwoLineDecoder(String input, int expected) {
        var one = new One();
        assertEquals(expected, one.partTwoLineDecoder(input));
    }

    static Stream<Arguments> partOneLineDecoder() {
        return Stream.of(
                arguments("1abc2", 12),
                arguments("pqr3stu8vwx", 38),
                arguments("a1b2c3d4e5f", 15),
                arguments("treb7uchet", 77)
        );
    }

    static Stream<Arguments> partTwoLineDecoder() {
        return Stream.of(
                arguments("two1nine", 29),
                arguments("eightwothree", 83),
                arguments("abcone2threexyz", 13),
                arguments("xtwone3four", 24),
                arguments("4nineeightseven2", 42),
                arguments("zoneight234", 14),
                arguments("7pqrstsixteen", 76),
                arguments("eighthree", 83),
                arguments("eighthree4vnfoisfive", 85),
                arguments("sevenine", 79),
                arguments("sevenine2", 72)
        );
    }

}
