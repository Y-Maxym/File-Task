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
    public String printGreetingsAndGetFilePath() {
        String message = """
                Hello!
                Please, write a filepath:
                """;
        System.out.print(message);

        String line;
        while (true) {
            line = scanner.nextLine();
            if (fileService.isValidFile(line, "txt")) break;
            else System.out.println("Invalid file, please try again:");
        }

        return line;
    }
}
