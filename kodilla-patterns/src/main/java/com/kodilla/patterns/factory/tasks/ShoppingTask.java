package com.kodilla.patterns.factory.tasks;


import com.kodilla.patterns.factory.Shape;

import java.util.ArrayList;
import java.util.List;

public final class ShoppingTask implements Task{

    private final String taskName;
    private final String whatToBuy;
    private final double quantity;
    private final static List<Boolean> theListOfCompletedTasks = new ArrayList<>();


    public ShoppingTask(final String taskName, final String whatToBuy, final double quantity) {
        this.taskName=taskName;
        this.whatToBuy=whatToBuy;
        this.quantity=quantity;
    }

    @Override
    public String getTaskName() {
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
        System.out.println("Checking if a given task has already been completed...");
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
