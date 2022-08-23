package com.kodilla.testing.shape;
import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {

    private List<Shape> shapes = new ArrayList<>();
    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public Shape getShape (int shapeNumber) {

        return shapes.get(shapeNumber);
    }

    public int shapesCount() {
        return shapes.size();
    }

    public boolean removeShape(Shape shape) {
        boolean result = false;
        if (shapes.contains(shape)) {
            shapes.remove(shape);
            result = true;
        }
        return result;
    }

    public String showFigures() {

        return shapes.toString();
    }

}



