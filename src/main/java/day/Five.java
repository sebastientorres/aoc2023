package day;

import org.springframework.stereotype.Service;

@Service(Five.DAY)
public class Five extends AbstractSolution implements Solution<Integer, Integer> {
    public static final String DAY = "5";

    @Override
    public Integer partOne() {
        return null;
    }

    @Override
    public Integer partTwo() {
        return null;
    }

    @Override
    public int getDay() {
        return Integer.valueOf(DAY);
    }
}
