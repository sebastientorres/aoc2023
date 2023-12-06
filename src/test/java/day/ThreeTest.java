package day;

import main.day.Solution;
import main.day.Three;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ThreeTest extends SolutionTest {

    @Test
    void partOne() {
        Solution solution = new Three();
        assertEquals(4361, solution.partOne());
    }




}
