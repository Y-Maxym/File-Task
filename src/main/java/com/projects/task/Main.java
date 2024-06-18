package com.projects.task;

import com.projects.task.service.console.ConsoleService;
import com.projects.task.service.file.FileService;
import com.projects.task.service.math.MathService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ComponentScan("com.projects.task")
public class Main {

    static ApplicationContext applicationContext;
    static ConsoleService consoleService;
    static FileService fileService;
    static MathService mathService;

    static {
        applicationContext = new AnnotationConfigApplicationContext(Main.class);
        consoleService = applicationContext.getBean(ConsoleService.class);
        fileService = applicationContext.getBean(FileService.class);
        mathService = applicationContext.getBean(MathService.class);
    }

    public static void main(String[] args) {
        consoleService.printGreetingMessage();
        String filePath = consoleService.getFilePath();

        long start = System.currentTimeMillis();
        List<Long> numbers = fileService.readNumbersFromFile(filePath);
        mathService.minMax(numbers);
        mathService.median(numbers);
        mathService.average(numbers);
        long end = System.currentTimeMillis();
        System.out.printf("Time spent: %.2f s.", (end - start) / 1000f);
    }
}