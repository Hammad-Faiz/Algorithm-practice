// Exercise 01 - Interfaces & Abstraction
// ----------------------------------------
// TODO 1: Create an interface called Shape with one method: area()
// TODO 2: Create a Circle class that implements Shape
//         - it should have a radius field
//         - area = Math.PI * radius * radius
// TODO 3: Create a Rectangle class that implements Shape
//         - it should have width and height fields
//         - area = width * height
// TODO 4: In main, add both shapes to an ArrayList<Shape>
//         loop through and print each area

import java.util.ArrayList;

public class Exercise01_Interfaces {

    // --- Write your interface here ---
    public interface Shape {
        double area();
    };


    // --- Write your Circle class here ---
    public static class Circle implements Shape{

        private double radius;

        public Circle(double radius) {
            this.radius = radius;
        };

        @Override
        public double area() {
            return Math.PI * radius * radius;
        }
    };


    // --- Write your Rectangle class here ---
    public static class Rectangle implements Shape{

        private double width, height;

        public Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        @Override
        public double area() {
            return width * height;
        }
    };


    // --- main: run and test your code ---
    public static void main(String[] args) {

        Circle circle = new Circle(8);
        Rectangle rectangle = new Rectangle(11, 12);

        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(circle);
        shapes.add(rectangle);


        for (Shape shape : shapes) {
          System.out.println(shape.area());
        };
    };
}
