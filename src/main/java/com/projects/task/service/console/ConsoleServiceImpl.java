package com.projects.task.service.console;

import com.projects.task.service.file.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class ConsoleServiceImpl implements ConsoleService {

    private final FileService fileService;
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void printGreetingMessage() {
        String message = """
                ---------------------------------
                Hello!
                Please, write a filepath or print exit:
                """;
        System.out.print(message);
    }

    @Override
    public String getFilePath() {
        String line;
        while (true) {
            line = scanner.nextLine();
            if ("exit".equalsIgnoreCase(line)) System.exit(0);
            if (fileService.isValidFile(line, "txt")) break;
            else System.out.println("Invalid file, please try again.");
        }

        return line;
    }

    @Override
    public void printSpendTime(String text, Double spendTime) {
        System.out.printf(text, spendTime);
    }
}