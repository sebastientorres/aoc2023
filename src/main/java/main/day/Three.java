package main.day;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component(Three.DAY)
public class Three extends AbstractSolution<Integer, Integer> {

    public static final String DAY = "3";

    @Override
    public Integer partOne() {
        return -1;
    }

    @Override
    public Integer partTwo() {
        return -1;
    }

    @Override
    public int getDay() {
        return Integer.valueOf(DAY);
    }
}
