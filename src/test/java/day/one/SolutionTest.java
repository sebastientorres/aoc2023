package day.one;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

class SolutionTest {

    private static final String path = "src/test/resources/day/one";
    private final Solution solution = new Solution();

    @Test
    public void partOne() {
        var file = new File(path+"/inputPartOne");
        var actual = solution.partOne(file);
        assertEquals(142, actual);
    }

    @ParameterizedTest
    @MethodSource
    void partOneLineDecoder(String input, int expected) {
        assertEquals(expected, solution.partOneLineDecoder(input));
    }

    @Test
    public void partTwo() {
        var file = new File(path+"/inputPartTwo");
        var actual = solution.partTwo(file);
        assertEquals(281, actual);
    }

    @ParameterizedTest
    @MethodSource
    void partTwoLineDecoder(String input, int expected) {
        assertEquals(expected, solution.partTwoLineDecoder(input));
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
                arguments("sevenine", 79)
        );
    }

}
