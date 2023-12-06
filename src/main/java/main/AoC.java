package main;

import main.day.Solution;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

@Service
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/aoc")
public class AoC implements Solution {

    private final Map<Integer, Solution> dayToSolutionMap;

    @GetMapping
    public String getTodaysSolution() {
        return getSolution(getToday());
    }

    @GetMapping("/{day}")
    public String getSolutionForDay(@PathVariable Integer day) {
        return getSolution(day);
    }

    private String getSolution(Integer day) {
        var solution = dayToSolutionMap.get(day);
        return "Day " + day + ", partOne = " + solution.partOne() + " partTwo = " + solution.partTwo();
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

    int getToday() {
        return today();
    }

}
