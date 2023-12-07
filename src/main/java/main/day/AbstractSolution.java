package main.day;

import lombok.Getter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class AbstractSolution<T, U> {

    public abstract int getDay();

    @Getter
    List<String> lines = new ArrayList<>();

    public AbstractSolution() {
        try {
            Scanner scanner = new Scanner(createSolutionFile());
            scanner.useDelimiter("\n");
            while (scanner.hasNext()) {
                var next = scanner.next();
                lines.add(next.trim());
            }

        } catch (FileNotFoundException e) {

        }
    }

    abstract T partOne();
    abstract U partTwo();

    private File createSolutionFile() {
        return new File("src/main/resources/day/" + getDay() + "/input");
    }

}
