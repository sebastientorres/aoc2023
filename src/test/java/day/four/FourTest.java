package day.four;

import day.Solution;
import day.SolutionTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class FourTest extends SolutionTest {

    @ParameterizedTest
    @MethodSource
    public void partOneLineParser(String line, int expectedPoints) {
        var solution = new Four();
        var actual = solution.pointsFromLine(line);
        assertEquals(expectedPoints, actual);
    }
    @Test
    void partOne() {
        Solution solution = new Four(createInputFile("inputPartOne"));
        assertEquals(13, solution.partOne());
    }

    static Stream<Arguments> partOneLineParser() {
        return Stream.of(
                arguments(card1, card1Points),
                arguments(card2, card2Points),
                arguments(card3, card3Points),
                arguments(card4, card4Points),
                arguments(card5, card5And6Points),
                arguments(card6, card5And6Points)
        );
    }

    static String card1 = "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53";
    static String card2 = "Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19";
    static String card3 = "Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1";
    static String card4 = "Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83";
    static String card5 = "Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36";
    static String card6 = "Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11";

    static int card1Points = 8;
    static int card2Points = 2;
    static int card3Points = 2;
    static int card4Points = 1;
    static int card5And6Points = 0;

}
