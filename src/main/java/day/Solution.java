package day;

import lombok.Setter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public abstract class Solution<T, U> {

    @Setter
    private File file = createSolutionFile();

    private final List<String> lines = new ArrayList<>();

    public List<String> getLines() {

        if (lines.isEmpty()) {
            try {
                Scanner scanner = new Scanner(file);
                scanner.useDelimiter("\n");

                var digits = new ArrayList<String>();

                while (scanner.hasNext()) {
                    lines.add(scanner.next());
                }
            } catch (FileNotFoundException e) {
                    System.out.println("Exception: " + e.getMessage());
            }
        }
        return lines;
    }

    public abstract T partOne();
    public abstract U partTwo();

    public abstract int today();

    protected File createSolutionFile() {
        return new File(getPath() + today() + "/input");
    }

    protected String getPath() {
        return "src/main/resources/day/";
    }

    public String getSolution() {
        return "Day " + today() + "'s solutions:\n" +
                "Part one: " + partOne() + "\n"+
                "Part two: " + partTwo();
    }

}
