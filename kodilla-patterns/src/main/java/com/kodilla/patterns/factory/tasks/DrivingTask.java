package com.kodilla.patterns.factory.tasks;


import java.util.ArrayList;
import java.util.List;

public class DrivingTask implements Task{

    private final String taskName;
    private final String where;
    private final String using;
    private final List<Boolean> theListOfCompletedTasks = new ArrayList<>();

    public DrivingTask(String taskName, String where, String using) {
        this.taskName = taskName;
        this.where = where;
        this.using = using;
    }

    @Override
    public String getTaskName(){
        return taskName;
    }

    public List<Boolean> getTheListOfCompletedTasks() {
        return theListOfCompletedTasks;
    }

    @Override
    public List<Boolean> executeTask() {
        System.out.println("Completing the current task...");
        boolean result = true;
        theListOfCompletedTasks.add(result);
        return theListOfCompletedTasks;
    }

    @Override
    public boolean isTaskExecuted() {
        System.out.println("Checking if the current driving task has already been completed...");
        Boolean task = theListOfCompletedTasks.get(0);
        boolean result = false;
        if(theListOfCompletedTasks.contains(task)) {
            result=true;
            System.out.println("The task has been completed.");
        }else{
            result=false;
            System.out.println("This task has not been completed yet.");
        }
        return result;
    }

}
