package com.projects.task.service.clock;

import com.projects.task.service.console.ConsoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class StopwatchServiceImpl implements StopwatchService {

    private final ConsoleService consoleService;

    @Override
    public void countingSeconds(List<Long> numbers, Consumer<List<Long>> consumer) {
        long start = System.currentTimeMillis();
        consumer.accept(numbers);
        long end = System.currentTimeMillis();
        consoleService.printSpendTime("Time spent on performing the function: %.2f s.\n", (end - start) / 1000.0);
    }

    @Override
    public List<Long> countingSeconds(String filePath, Function<String, List<Long>> function) {
        long start = System.currentTimeMillis();
        List<Long> result = function.apply(filePath);
        long end = System.currentTimeMillis();
        consoleService.printSpendTime("Time spent reading the file: %.2f s.\n", (end - start) / 1000.0);
        return result;
    }
}