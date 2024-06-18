package com.projects.task.service.math;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MathServiceImpl implements MathService {

    @Override
    public void minMax(List<Long> numbers) {
        long max = numbers.getFirst();
        long min = numbers.getFirst();

        for (Long number : numbers) {
            max = Math.max(max, number);
            min = Math.min(min, number);
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
    public void maxIncreasingSequence(List<Long> numbers) {
        if (numbers.size() < 2) {
            System.out.println("Max increasing sequence: []");
            return;
        }

        int startSeq = 0;
        int endSeq = 0;
        int currStart = 0;

        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) <= numbers.get(i - 1)) {
                if (i - 1 - currStart > endSeq - startSeq) {
                    startSeq = currStart;
                    endSeq = i - 1;
                }
                currStart = i;
            }
        }

        if (numbers.getLast() > numbers.get(numbers.size() - 2)
                && (numbers.size() - 1 - currStart > endSeq - startSeq)) {
            startSeq = currStart;
            endSeq = numbers.size() - 1;
        }

        List<Long> sequence = startSeq == endSeq ?
                new ArrayList<>() : numbers.subList(startSeq, endSeq + 1);

        System.out.printf("Max increasing sequence: %s\n", sequence);
    }

    @Override
    public void maxDecreasingSequence(List<Long> numbers) {
        if (numbers.size() < 2) {
            System.out.println("Max decreasing sequence: []");
            return;
        }

        int startSeq = 0;
        int endSeq = 0;
        int currStart = 0;

        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) >= numbers.get(i - 1)) {
                if (i - 1 - currStart > endSeq - startSeq) {
                    startSeq = currStart;
                    endSeq = i - 1;
                }
                currStart = i;
            }
        }

        if (numbers.getLast() < numbers.get(numbers.size() - 2)
                && (numbers.size() - 1 - currStart > endSeq - startSeq)) {
            startSeq = currStart;
            endSeq = numbers.size() - 1;
        }

        List<Long> sequence = startSeq == endSeq ?
                new ArrayList<>() : numbers.subList(startSeq, endSeq + 1);

        System.out.printf("Max decreasing sequence: %s\n", sequence);
    }

    @Override
    public void allFunctions(List<Long> numbers) {
        minMax(numbers);
        median(numbers);
        average(numbers);
        maxIncreasingSequence(numbers);
        maxDecreasingSequence(numbers);
    }
}