package com.kodilla.petterns.factory.tasks;


import com.kodilla.patterns.factory.tasks.ShoppingTask;
import com.kodilla.patterns.factory.tasks.Task;
import com.kodilla.patterns.factory.tasks.TaskFactory;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TaskFactoryTestSuite {

    @Test
    void testFactoryShoppingTask() {
        //Given
        TaskFactory factory = new TaskFactory();

        //When
        Task shoppingTask = factory.prepareAndVerifyATask(TaskFactory.SHOPPINGTASK);

        //Then
        assertEquals("Buying notebooks", shoppingTask.getTaskName());
        assertEquals(1, shoppingTask.executeTask().size());
        assertTrue(shoppingTask.isTaskExecuted());
    }

    @Test
    void testFactoryPaintingTest() {
        //Given
        TaskFactory factory = new TaskFactory();

        //When
        Task paintingTask = factory.prepareAndVerifyATask(TaskFactory.PAINTINGTASK);

        //Then
        assertEquals("Painting the living room", paintingTask.getTaskName());
        assertEquals(1,paintingTask.executeTask().size());
        assertTrue(paintingTask.isTaskExecuted());
    }

    @Test
    void testFactoryDrivingTest() {
        //Given
        TaskFactory factory = new TaskFactory();

        //When
        Task drivingTask = factory.prepareAndVerifyATask(TaskFactory.DRIVINGTASK);

        //Then
        assertEquals("Delivering parcels",drivingTask.getTaskName());
        assertEquals(1, drivingTask.executeTask().size());
        assertTrue(drivingTask.isTaskExecuted());
    }
}
