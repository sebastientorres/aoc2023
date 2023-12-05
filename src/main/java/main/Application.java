package main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"main", "day"})
public class Application {

    @Autowired
    private AoC aoc;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
