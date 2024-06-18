package com.projects.task.service.clock;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public interface StopwatchService {

    void countingSeconds(List<Long> numbers, Consumer<List<Long>> consumer);

    List<Long> countingSeconds(String filePath, Function<String, List<Long>> function);

}