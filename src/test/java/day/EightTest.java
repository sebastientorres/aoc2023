package day;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class EightTest extends SolutionTest<Eight> {

    @BeforeEach
    @Override
    void before() {
        solution = new Eight();
    }

    @Override
    int getDay() {
        return 8;
    }

    @Test
    void inputOneExampleOne() {
        solution.setFile(createInputFile("inputExample1"));
        solution.setDirections("RL");
        assertEquals(2, solution.partOne());
    }

    @Test
    void inputOneExampleTwo() {
        solution.setFile(createInputFile("inputExample2"));
        solution.setDirections("LLR");
        assertEquals(6, solution.partOne());
    }

    @ParameterizedTest
    @MethodSource
    void lineParser(String inputFileName, String directions, Map<String, String> expected) {
        solution.setFile(createInputFile(inputFileName));
        solution.setDirections(directions);
        var actual = solution.lineParser(solution.getLines());

        assertEquals(expected, actual);
    }

    static Stream<Arguments> lineParser() {
        return Stream.of(
                arguments("inputExample1", "RL", inputExample1Expected),
                arguments("inputExample2", "LLR", inputExample2Expected)
        );
    }

    private static Map<String, MapEntry> inputExample1Expected
            = Map.of(
            "AAA" , new MapEntry("AAA", "BBB", "CCC"),
            "BBB" , new MapEntry("BBB", "DDD", "EEE"),
            "CCC" , new MapEntry("CCC", "ZZZ", "GGG"),
            "DDD" , new MapEntry("DDD", "DDD", "DDD"),
            "EEE" , new MapEntry("EEE", "EEE", "EEE"),
            "GGG" , new MapEntry("GGG", "GGG", "GGG"),
            "ZZZ" , new MapEntry("ZZZ", "ZZZ", "ZZZ")
    );

    private static Map<String, MapEntry> inputExample2Expected
            = Map.of(
            "AAA" , new MapEntry("AAA", "BBB", "BBB"),
            "BBB" , new MapEntry("BBB", "AAA", "ZZZ"),
            "ZZZ" , new MapEntry("ZZZ", "ZZZ", "ZZZ")
    );
}
