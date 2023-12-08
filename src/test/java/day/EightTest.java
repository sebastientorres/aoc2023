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
        assertEquals(2, solution.partOne());
    }

    @Test
    void inputOneExampleTwo() {
        solution.setFile(createInputFile("inputExample2"));
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

    private static Map<String, String> inputExample1Expected
            = Map.of(
            "AAA" , "(BBB, CCC)",
            "BBB" , "(DDD, EEE)",
            "CCC" , "(ZZZ, GGG)",
            "DDD" , "(DDD, DDD)",
            "EEE" , "(EEE, EEE)",
            "GGG" , "(GGG, GGG)",
            "ZZZ" , "(ZZZ, ZZZ)"
    );

    private static Map<String, String> inputExample2Expected
            = Map.of(
            "AAA" , "(BBB, BBB)",
            "BBB" , "(AAA, ZZZ)",
            "ZZZ" , "(ZZZ, ZZZ)"
    );
}
