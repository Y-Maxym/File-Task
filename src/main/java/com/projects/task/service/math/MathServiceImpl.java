package com.projects.task.service.math;

import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class MathServiceImpl implements MathService {

    @Override
    public void minMax(List<Long> numbers) {
        long max = numbers.getFirst();
        long min = numbers.getFirst();

        for (Long number : numbers) {
            if (number > max) max = number;
            if (number < min) min = number;
        }
        System.out.printf("Max: %d\nMin: %d\n", max, min);
    }

    @Override
    public void median(List<Long> numbers) {
        int length = numbers.size();

        if (length % 2 == 0) {
            long first = numbers.get(length / 2);
            long second = numbers.get(length / 2 - 1);
            System.out.printf("Median: %.2f\n", (first + second) / 2f);
            return;
        }

        System.out.printf("Median: %d\n", numbers.get(length / 2));
    }

    @Override
    @SuppressWarnings("all")
    public void average(List<Long> numbers) {
        float length = numbers.size();

        Long sum = numbers.stream()
                .reduce(Long::sum)
                .get();

        System.out.printf("Average: %.2f\n", sum / length);
    }

    @Override
    public void maxSequence(List<Long> numbers) {

    }

    @Override
    public void minSequence(List<Long> numbers) {

    }
}
