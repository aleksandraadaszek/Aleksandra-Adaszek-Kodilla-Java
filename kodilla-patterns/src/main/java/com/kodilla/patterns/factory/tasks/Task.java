package com.kodilla.patterns.factory.tasks;


import com.kodilla.patterns.factory.Shape;

import java.util.List;

public interface Task {

    public List<Boolean> executeTask();
    public String getTaskName();
    public boolean isTaskExecuted();
}
