package com.kodilla.patterns.factory.tasks;


import com.kodilla.patterns.factory.Shape;

import java.util.ArrayList;
import java.util.List;

public final class ShoppingTask implements Task{

    private final String taskName;
    private final String whatToBuy;
    private final double quantity;
    private  boolean isTaskDone = false;


    public ShoppingTask(final String taskName, final String whatToBuy, final double quantity) {
        this.taskName=taskName;
        this.whatToBuy=whatToBuy;
        this.quantity=quantity;
    }

    @Override
    public String getTaskName() {
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
