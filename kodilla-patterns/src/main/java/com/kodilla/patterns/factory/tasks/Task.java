package com.kodilla.patterns.factory.tasks;


import com.kodilla.patterns.factory.Shape;

import java.util.List;

public interface Task {

    public void executeTask();
    public String getTaskName();
    public boolean isTaskExecuted();
}
