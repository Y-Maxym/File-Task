package com.projects.task.service.file;

import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Component
public class FileServiceImpl implements FileService {

    @Override
    public List<Long> readNumbersFromFile(String filePath) {
        try {
            List<String> lines = Files.readAllLines(Path.of(filePath));
            List<Long> numbers = new ArrayList<>();

            for (String line : lines) {
                if (line.trim().isEmpty()) continue;

                try {
                    numbers.add(Long.parseLong(line.trim()));
                } catch (NumberFormatException ignore) {
                }
            }

            return numbers;
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return new ArrayList<>();
    }

    @SneakyThrows
    public boolean isValidFile(String filePath, String expectedExtension) {
        Path path = Path.of(filePath);
        if (!Files.exists(path) || !Files.isRegularFile(path)) return false;

        String fileName = path.getFileName().toString();

        int extensionIndex = fileName.lastIndexOf('.');
        if (extensionIndex == -1) return false;

        String extension = fileName.substring(extensionIndex + 1);
        if (!extension.equalsIgnoreCase(expectedExtension)) return false;

        return Files.size(path) != 0;
    }
}
