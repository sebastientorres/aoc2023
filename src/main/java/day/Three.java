package day;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service(Three.DAY)
public class Three extends AbstractSolution implements Solution<Integer, Integer> {

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
