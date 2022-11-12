package com.kodilla.spring.portfolio;


import java.util.ArrayList;
import java.util.List;

public class TaskList {

    private List<String> tasks;

    public TaskList () {
        tasks = new ArrayList<>();
    }

    public void addTasks (String task) {
        tasks.add(task);
    }

    public List<String> getTasks () {
        return tasks;
    }

    @Override
    public String toString() {
        return
                "" + tasks.toString()
                ;
    }
}

