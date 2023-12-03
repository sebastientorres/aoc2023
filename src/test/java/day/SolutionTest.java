package day;

import java.io.File;

public abstract class SolutionTest {

    protected File createInputFile(String fileName) {
        return new File(getPath() + "/" + fileName);
    }

    protected String getPath() {
        return "src/test/resources/day/" + geDay();
    }

    private String geDay() {
        String packageName = getClass().getPackageName();
        int index = packageName.lastIndexOf(".");
        return packageName.substring(index + 1, packageName.length());
    }

}
