package com.projects.task.service.file;

public interface FileService {

    long[] readNumbersFromFile(String filePath);

    boolean isValidFile(String filePath, String expectedExtension);
}
