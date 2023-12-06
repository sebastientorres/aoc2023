package main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {"main.day"})
@ComponentScan(basePackages = "main.day")
public class Application {


    @Autowired
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
