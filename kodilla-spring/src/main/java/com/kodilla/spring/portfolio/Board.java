package com.kodilla.spring.portfolio;


import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private  TaskList toDoList ;
    private  TaskList inProgressList ;
    private  TaskList doneList ;

    public Board(TaskList toDoList, TaskList inProgressList, TaskList doneList) {
        this.toDoList = toDoList;
        this.inProgressList = inProgressList;
        this.doneList = doneList;
    }

    public TaskList getToDoList() {
        return toDoList;
    }

    public TaskList getInProgressList() {
        return inProgressList;
    }

    public TaskList getDoneList() {
        return doneList;
    }

    public String toString (){
        return toDoList + "on the list: toDoList" + " " + inProgressList + "on the list: inProgressList" +  " " + doneList + "on the list: doneList";
    }
}
