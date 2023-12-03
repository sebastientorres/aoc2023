package day.three;

import day.Solution;
import day.SolutionTest;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ThreeTest implements SolutionTest {

    @Test
    void partOne() {
        Solution solution = new Three(new File(getPath()+"/inputPartOne"));
        assertEquals(4361, solution.partOne());
    }

    @Override
    public String geDay() {
        return "3";
    }
}