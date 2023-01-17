package com.kodilla.patterns.factory.tasks;


public class TaskFactory {

    public static final String SHOPPINGTASK = "Shopping task";
    public static final String PAINTINGTASK = "Painting task";
    public static final String DRIVINGTASK = "Driving task";


    public final Task prepareAndVerifyATask(final String taskClass) {
        switch(taskClass) {
            case SHOPPINGTASK:
                return new ShoppingTask("Buying notebooks","Some new notebooks",3.00 );
            case PAINTINGTASK:
                return new PaintingTask("Painting the living room", "Light blue","All walls");
            case DRIVINGTASK:
                return new DrivingTask("Delivering parcels", "Warsaw", "The old van");
            default:
                return null;
        }
    }
}
