package com.projects.task;

import com.projects.task.service.console.ConsoleService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.projects.task")
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        ConsoleService consoleService = context.getBean(ConsoleService.class);

        String filePath = consoleService.printGreetingsAndGetFilePath();
        System.out.println(filePath);
    }
}