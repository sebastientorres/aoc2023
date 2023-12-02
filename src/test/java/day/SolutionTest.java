package day;

public interface SolutionTest {
    default String getPath() {
        return "src/test/resources/day/" + geDay();
    }

    String geDay();

}
