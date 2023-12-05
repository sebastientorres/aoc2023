package day;

import day.Solution;
import day.SolutionTest;
import day.Three;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ThreeTest extends SolutionTest {

    @Test
    void partOne() {
        Solution solution = new Three(createInputFile("inputPartOne"));
        assertEquals(4361, solution.partOne());
    }




}
