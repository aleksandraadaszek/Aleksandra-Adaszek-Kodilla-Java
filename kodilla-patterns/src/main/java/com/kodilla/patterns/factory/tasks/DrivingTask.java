package com.kodilla.patterns.factory.tasks;


import java.util.ArrayList;
import java.util.List;

public class DrivingTask implements Task{

    private final String taskName;
    private final String where;
    private final String using;
    private boolean isTaskDone;

    public DrivingTask(String taskName, String where, String using) {
        this.taskName = taskName;
        this.where = where;
        this.using = using;
    }

    @Override
    public String getTaskName(){
        return taskName;
    }


    @Override
    public void executeTask() {
        System.out.println("Completing the current task...");
        isTaskDone = true;
    }

    @Override
    public boolean isTaskExecuted() {
        return isTaskDone;
    }

}
