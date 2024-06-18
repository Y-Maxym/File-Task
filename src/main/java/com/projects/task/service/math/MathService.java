package com.projects.task.service.math;

import java.util.List;

public interface MathService {

    void minMax(List<Long> numbers);

    void median(List<Long> numbers);

    void average(List<Long> numbers);

    void maxIncreasingSequence(List<Long> numbers);

    void maxDecreasingSequence(List<Long> numbers);

    void allFunctions(List<Long> numbers);
}