package main.day;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AoC {

    @Autowired
    private final SolutionProvider provider;

    public String getTodaysSolution() {
        return provider.getTodaysSolution();
    }

    public String getSolutionForDay(Integer day) {
        return provider.getSolutionForDay(day);
    }


}
