package day;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class NineTest extends SolutionTest<Nine> {

    @Override
    @BeforeEach
    void before() {
        solution = new Nine();
    }

    @Override
    int getDay() {
        return 9;
    }

    @ParameterizedTest
    @MethodSource
    void findNextInSequence(String input, int expected) {
        var actual = solution.findNextInSequence(input);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> findNextInSequence() {
        return Stream.of(
                arguments(seqeunce1, 18),
                arguments(seqeunce2, 28),
                arguments(seqeunce3, 68)
        );
    }

    static String seqeunce1 = "0 3 6 9 12 15";
    static String seqeunce2 = "1 3 6 10 15 21";
    static String seqeunce3 = "10 13 16 21 30 45";

    @ParameterizedTest
    @MethodSource
    void findDifferences(Integer[] sequence, Integer[] expected) {
        var actual = solution.findDifferences(sequence);
        assertArrayEquals(expected, actual);
    }

    static Stream<Arguments> findDifferences() {
        return Stream.of(
                arguments(new Integer[]{0, 3, 6, 9, 12, 15}, new Integer[]{3, 3, 3, 3, 3}),
                arguments(new Integer[] {1, 3, 6, 10, 15, 21}, new Integer[]{2, 3, 4, 5, 6}),
                arguments(new Integer[]{10, 13, 16, 21, 30, 45}, new Integer[]{3, 3, 5, 9, 15})
        );
    }

    @Test
    void partOne() {
        solution.setFile(createInputFile("inputExample"));
        var actual = solution.partOne();
        assertEquals(114, actual);
    }
}