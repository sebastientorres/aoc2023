package day;

import day.Solution;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Three extends Solution<Integer, Integer> {

    public static final int DAY = 3;

    @Override
    public Integer partOne() {

        List<String[]> lines = new ArrayList<>();

        for (String line : getLines()) {
            lines.add(line.split(""));
        }

        for(int i = 0; i < lines.size(); i++) {
            var line = lines.get(i);
            String l = "";
            for (int j = 0; j < line.length; j++) {
                l += line[j] +  " ";
            }
            System.out.println(l.trim());
        }

        return -1;
    }

    @Override
    public Integer partTwo() {
        return -1;
    }

    @Override
    public int today() {
        return DAY;
    }
}
