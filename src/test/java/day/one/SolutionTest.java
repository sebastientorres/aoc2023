package day.one;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private static final String path = "src/test/resources/day/one";
    private final Solution solution = new Solution();

    @Test
    public void partOne() {
        var file = new File(path+"/inputPartOne");
        var actual = solution.partOne(file);
        assertEquals(77, actual);
    }

    @Test
    public void partTwo() {
        var file = new File(path+"/inputPartTwo");
        var actual = solution.partTwo(file);
        assertEquals(281, actual);
    }

}
