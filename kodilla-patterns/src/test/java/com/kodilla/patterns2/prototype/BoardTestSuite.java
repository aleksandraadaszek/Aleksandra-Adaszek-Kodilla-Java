package com.kodilla.patterns2.prototype;


import com.kodilla.patterns.prototype.Board;
import com.kodilla.patterns.prototype.Task;
import com.kodilla.patterns.prototype.TasksList;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BoardTestSuite {

    @Test
    void testToString() {
        //Given
        TasksList listToDo = new TasksList("To do tasks");
        IntStream.iterate(1, n->n+1)
                .limit(10)
                .forEach(n-> listToDo.getTasks().add(new Task("To do task number: " + n)));

        TasksList inProgressList = new TasksList("In progress tasks");
        IntStream.iterate(1,n->n+1)
                .limit(10)
                .forEach(n->inProgressList.getTasks().add(new Task("In progress task number: " + n)));

        TasksList tasksDone = new TasksList("Completed tasks");
        IntStream.iterate(1, n->n+1)
                .limit(10)
                .forEach(n->tasksDone.getTasks().add(new Task("An already completed task number: " + n)));

        Board board = new Board("Project number1");
        board.getLists().add(listToDo);
        board.getLists().add(inProgressList);
        board.getLists().add(tasksDone);

        Board clonedBoard = null;
        try{
            clonedBoard = board.shallowCopy();
            clonedBoard.setName("Project number 2");
        }catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

            Board deepClonedBoard = null;
            try {
                deepClonedBoard = board.deepCopy();
                deepClonedBoard.setName("Project number 3");
            }catch(CloneNotSupportedException e) {
                System.out.println(e);
            }

        //When
        board.getLists().remove(listToDo);

        // Then
        System.out.println(board);
        System.out.println(clonedBoard);
        System.out.println(deepClonedBoard);
        assertEquals(2,board.getLists().size());
        assertEquals(2,clonedBoard.getLists().size());
        assertEquals(3, deepClonedBoard.getLists().size());
        assertEquals(clonedBoard.getLists(),board.getLists());
        assertNotEquals(deepClonedBoard.getLists(), board.getLists());
    }
}
