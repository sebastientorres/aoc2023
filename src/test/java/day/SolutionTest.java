package day;

import java.io.File;

public abstract class SolutionTest<T> {

    T solution;

    abstract void before();

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
