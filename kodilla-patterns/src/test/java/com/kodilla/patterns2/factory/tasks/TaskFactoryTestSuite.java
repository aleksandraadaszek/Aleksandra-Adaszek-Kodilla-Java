package com.kodilla.patterns2.factory.tasks;


import com.kodilla.patterns.factory.tasks.Task;
import com.kodilla.patterns.factory.tasks.TaskFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskFactoryTestSuite {

    @Test
    void testFactoryShoppingTask() {
        //Given
        TaskFactory factory = new TaskFactory();

        //When
        Task shoppingTask = factory.prepareAndVerifyATask(TaskFactory.SHOPPINGTASK);
        shoppingTask.executeTask();

        //Then
        assertEquals("Buying notebooks", shoppingTask.getTaskName());

        assertTrue(shoppingTask.isTaskExecuted());
    }

    @Test
    void testFactoryPaintingTest() {
        //Given
        TaskFactory factory = new TaskFactory();

        //When
        Task paintingTask = factory.prepareAndVerifyATask(TaskFactory.PAINTINGTASK);
        paintingTask.executeTask();

        //Then
        assertEquals("Painting the living room", paintingTask.getTaskName());
        assertTrue(paintingTask.isTaskExecuted());
    }

    @Test
    void testFactoryDrivingTest() {
        //Given
        TaskFactory factory = new TaskFactory();

        //When
        Task drivingTask = factory.prepareAndVerifyATask(TaskFactory.DRIVINGTASK);
        drivingTask.executeTask();

        //Then
        assertEquals("Delivering parcels",drivingTask.getTaskName());
        assertTrue(drivingTask.isTaskExecuted());
    }
}
