package day.two;

import day.Solution;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.File;

@AllArgsConstructor
@NoArgsConstructor
public class Two implements Solution<Integer, Integer> {

    @Setter
    private File file;

    @Override
    public Integer partOne() {
        return 100;
    }

    @Override
    public Integer partTwo() {
        return -2;
    }
}
