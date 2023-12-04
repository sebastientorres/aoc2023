package main;

import day.Solution;
import day.four.Four;
import day.one.One;
import day.three.Three;
import day.two.Two;

import java.io.File;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class AoC implements Solution {

    public static void main(String[] args) {
        var aoc = new AoC();

        System.out.println("Day " + aoc.today() + "'s solutions:");
        System.out.println("Part one: " + aoc.partOne());
        System.out.println("Part two: " + aoc.partTwo());
    }

    Map<Integer, Solution> dayToSolutionMap = new HashMap<>();

    {
        dayToSolutionMap.put(1, new One(createSolutionFile()));
        dayToSolutionMap.put(2, new Two(createSolutionFile()));
        dayToSolutionMap.put(3, new Three(createSolutionFile()));
        dayToSolutionMap.put(4, new Four(createSolutionFile()));
    }

    @Override
    public Object partOne() {
        return dayToSolutionMap.get(today()).partOne();
    }

    @Override
    public Object partTwo() {
        return dayToSolutionMap.get(today()).partTwo();
    }

    public static int today() {
        return LocalDateTime.now().getDayOfMonth();
    }

    private File createSolutionFile() {
        return new File("src/main/resources/day/" + today() + "/input");
    }

}
