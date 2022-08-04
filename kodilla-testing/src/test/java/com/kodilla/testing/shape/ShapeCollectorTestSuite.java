package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Nested;

import java.util.List;


@DisplayName("TDD: Shape Collector Test Suite")

    public class ShapeCollectorTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Nested
    @DisplayName("Tests for adding")
    class TestAdd {

        @Test
        // Test sprawdzający czy po dodaniu nowego kształtu liczba elementów w kolekcji wynosi 1
        void testAddShape() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();

            //When
            Shape shape = new Circle("circle1", 3.4);
            shapeCollector.addShape(shape);

            //Then
            Assertions.assertEquals(1, shapeCollector.getShapes(0).size());
        }

        @Test
        //Test sprawdzający czy kształt pobrany z klasy ShapeCollector jest taki sam jak kształt do niej dodany
        void testGetShape() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Circle circle = new Circle("circle1", 4.5);
            shapeCollector.addShape(circle);

            //When
            List<Shape> retrievedCircle;
            retrievedCircle = shapeCollector.getShapes(0);

            //Then
            Assertions.assertEquals(circle, retrievedCircle);
        }
    }

    @Nested
    @DisplayName("Tests for removing")
    class TestRemoval {

        @Test
        // Test sprawdzający czy udało się usunąć wcześniej dodany kształt z kolekcji
        void testRemoveShape() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape shape = new Triangle("triangle1", 2.8, 3.4);
            shapeCollector.addShape(shape);

            //When
            boolean result = shapeCollector.removeShape(shape);

            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(0, shapeCollector.shapesCount());
        }

        @Test
        // Test sprawdzający czy po usunięciu 1 z 2 dodanych figur, druga z figur przeskoczy na pozycję indeksu 0
        void testAdding2ShapesAndRemoving1 () {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape circle1 = new Circle ("circle1", 3.98);
            Square square1 = new Square ("Square1", 7.88);
            shapeCollector.addShape(square1);
            shapeCollector.addShape(circle1);

            //When
            shapeCollector.removeShape(square1);

            //Then
            Assertions.assertEquals(circle1, shapeCollector.getShapes(0));
        }

        @Test
        //Test sprawdzający czy próba usunięcia nieistniejącego kształtu zwróci wynik false
        void testRemoveNonExistingShape() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Square square = new Square("square1", 32.3);

            //When
            boolean result = shapeCollector.removeShape(square);

            //Then
            Assertions.assertFalse(result);
        }
    }
}
