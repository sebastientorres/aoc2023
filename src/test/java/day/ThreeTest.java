package day;

import day.Solution;
import day.SolutionTest;
import day.Three;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ThreeTest extends SolutionTest<Three> {

    @Override
    int getDay() {
        return 3;
    }

    @BeforeEach
    void before() {
        solution = new Three();
        solution.setFile(createInputFile());
    }

    @Test
    void partOneTest() {
        Solution solution = new Three();
        assertEquals(4361, solution.partOne());
    }




}
