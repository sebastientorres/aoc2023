package day.three;

import day.Solution;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@NoArgsConstructor
@AllArgsConstructor
public class Three implements Solution<Integer, Integer> {

    private File file;

    @Override
    public Integer partOne() {

        List<String[]> lines = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(file);

            scanner.useDelimiter("\n");

            while (scanner.hasNext()) {
                var line = scanner.next();
                lines.add(line.split(""));
            }

        } catch (FileNotFoundException e) {
            return -1;
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
}
