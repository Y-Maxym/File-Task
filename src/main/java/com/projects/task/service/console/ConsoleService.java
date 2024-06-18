package com.projects.task.service.console;

public interface ConsoleService {

    void printGreetingMessage();

    String getFilePath();

    void printSpendTime(String text, Double spendTime);
}