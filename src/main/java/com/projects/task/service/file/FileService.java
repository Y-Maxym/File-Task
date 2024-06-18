package com.projects.task.service.file;

import java.util.List;

public interface FileService {

    List<Long> readNumbersFromFile(String filePath);

    boolean isValidFile(String filePath, String expectedExtension);
}