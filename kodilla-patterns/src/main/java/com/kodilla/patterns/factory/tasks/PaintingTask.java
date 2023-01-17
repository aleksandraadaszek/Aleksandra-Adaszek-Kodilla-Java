package com.kodilla.patterns.factory.tasks;


import java.util.ArrayList;
import java.util.List;

public class PaintingTask implements Task{

    private final String taskName;
    private final String colour;
    private final String whatToPaint;
    private final List<Boolean> theListOfCompletedTasks = new ArrayList<>();


    public PaintingTask(final String taskName, final String colour, final String whatToPaint) {
        this.taskName=taskName;
        this.colour=colour;
        this.whatToPaint=whatToPaint;
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
        System.out.println("Checking if the current painting task has already been completed...");
        Boolean task = theListOfCompletedTasks.get(0);
        boolean result = false;
        if (theListOfCompletedTasks.contains(task)) {
            result = true;
            System.out.println("This painting task has been successfully completed.");
        }else {
            result = false;
            System.out.println("This task still awaits its completion");
        }
            return result;
        }
    }


