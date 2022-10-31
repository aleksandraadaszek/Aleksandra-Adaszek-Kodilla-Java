package com.kodilla.spring.portfolio;


import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTestSuite {


    @Test

    public void testAddTask () {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);

        Board board = context.getBean(Board.class);
        //context.getBean(Board.class).getInProgressList().addTasks();
        board.getToDoList().addTasks("task1");
        board.getInProgressList().addTasks("task2");
        board.getDoneList().addTasks("task3");
        //When
        String toDoList = board.getToDoList().getTasks().get(0);
        String inProgressList = board.getInProgressList().getTasks().get(0);
        String doneList = board.getDoneList().getTasks().get(0);
        System.out.println("Available tasks: " + " " + board);

        //Then
        assertEquals("task1", toDoList);
        assertEquals("task2", inProgressList);
        assertEquals("task3", doneList);



    }
}
