package com.kodilla.patterns.factory.tasks;


import java.util.ArrayList;
import java.util.List;

public class PaintingTask implements Task{

    private final String taskName;
    private final String colour;
    private final String whatToPaint;
    private boolean isTaskDone;


    public PaintingTask(final String taskName, final String colour, final String whatToPaint) {
        this.taskName=taskName;
        this.colour=colour;
        this.whatToPaint=whatToPaint;
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


