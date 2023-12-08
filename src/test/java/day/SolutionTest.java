package day;

import java.io.File;
import java.time.LocalDate;

public abstract class SolutionTest {

    File createInputFile() {
        return createInputFile("input");
    }

    File createInputFile(String fileName) {
        return new File(getPath() + "/" + fileName);
    }

    protected String getPath() {
        return "src/test/resources/day/" + getDay();
    }

    abstract int getDay();

}
