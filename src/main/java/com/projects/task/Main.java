package com.projects.task;

import com.projects.task.service.clock.StopwatchService;
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

    private static final ConsoleService consoleService;
    private static final  FileService fileService;
    private static final MathService mathService;
    private static final StopwatchService stopwatchService;

    static {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Main.class);
        consoleService = applicationContext.getBean(ConsoleService.class);
        fileService = applicationContext.getBean(FileService.class);
        mathService = applicationContext.getBean(MathService.class);
        stopwatchService = applicationContext.getBean(StopwatchService.class);
    }

    public static void main(String[] args) {
        while (true) {
            consoleService.printGreetingMessage();
            String filePath = consoleService.getFilePath();
            List<Long> numbers = stopwatchService.countingSeconds(filePath, fileService::readNumbersFromFile);
            stopwatchService.countingSeconds(numbers, mathService::allFunctions);
        }
    }
}