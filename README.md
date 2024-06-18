# Numbers Finder

This application reads a text file containing numbers and calculates various statistics, including the longest increasing and decreasing sequence of numbers, the maximum value, the minimum value, the average, and the median. The results are printed to the console.

## How to Run

1. Download the ready-made JAR file from the [Releases](https://github.com/Y-Maxym/File-Task/releases) section (final version).
2. Execute the following command:

    ```
    java -jar <path_to_file>.jar
    ```

3. Enter the path to the text file containing the numbers when prompted. The program will output brief statistics and the results.

## Features

- **Find Maximum Value**: Identifies the highest number in the file.
- **Find Minimum Value**: Identifies the lowest number in the file.
- **Calculate Average**: Computes the average of all numbers.
- **Calculate Median**: Finds the median value of the numbers.
- **Find Longest Increasing Sequence**: Identifies the longest sequence of increasing numbers.
- **Find Longest Decreasing Sequence**: Identifies the longest sequence of decreasing numbers.

## Services

The application is composed of several services:

1. **FileService**: Handles file access.
2. **ConsoleService**: Manages console input and output.
3. **MathService**: Performs all calculations.
4. **StopwatchService**: Measures the execution time of the program.

## Example

```
java -jar file_task-final.jar
```

## Download

You can download the final version JAR file from the [Releases](https://github.com/Y-Maxym/File-Task/releases/tag/final) section.
