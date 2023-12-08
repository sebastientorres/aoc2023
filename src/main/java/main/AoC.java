package main;

import day.Eight;
import day.Solution;
import day.Four;
import day.One;
import day.Three;
import day.Two;

import java.io.File;
import java.time.LocalDateTime;
import java.util.Map;

public class AoC {

    public static void main(String[] args) {
        System.out.println( new AoC().getSolution());
    }

    Map<Integer, Solution> dayToSolutionMap = Map.of(
            One.DAY, new One(),
            Two.DAY, new Two(),
            Three.DAY, new Three(),
            Four.DAY, new Four(),
            Eight.DAY, new Eight()
    );

    public int today() {
        return LocalDateTime.now().getDayOfMonth();
    }

    private String getSolution() {
        return getSolutionFromDay(today());
    }

    private String getSolutionFromDay(int day) {
        return dayToSolutionMap.get(day).getSolution();
    }

}
