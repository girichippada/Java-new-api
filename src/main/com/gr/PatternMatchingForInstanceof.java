package com.gr;

interface Shape {
    static double getPerimeter(Shape shape) throws IllegalArgumentException {
        if (shape instanceof Rectangle) {
            Rectangle r = (Rectangle) shape;
            return 2 * r.length() + 2 * r.width();
        } else if (shape instanceof Circle) {
            Circle c = (Circle) shape;
            return 2 * c.radius() * Math.PI;
        } else {
            throw new IllegalArgumentException("Unrecognized shape");
        }
    }
}

record Rectangle(double length, double width) implements Shape {
}

record Circle(double radius) implements Shape {
}

interface ShapeWithPatternMatcher {
    static double getPerimeter(ShapeWithPatternMatcher shape) throws IllegalArgumentException {
        if (shape instanceof RectangleWithPatternMatcher r) {
            return 2 * r.length() + 2 * r.width();
        } else if (shape instanceof CircleWithPatternMatcher c) {
            return 2 * c.radius() * Math.PI;
        } else {
            throw new IllegalArgumentException("Unrecognized shape");
        }
    }
}

record RectangleWithPatternMatcher(double length, double width) implements ShapeWithPatternMatcher {
}

record CircleWithPatternMatcher(double radius) implements ShapeWithPatternMatcher {
}
public class PatternMatchingForInstanceof {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle(6,8);
        Shape circle = new Circle(10);

        System.out.println("Rectangle Perimeter: %s".formatted(Shape.getPerimeter(rectangle)));
        System.out.println("Circle Perimeter: %s".formatted(Shape.getPerimeter(circle)));

        ShapeWithPatternMatcher rectangle1 = new RectangleWithPatternMatcher(6,8);
        ShapeWithPatternMatcher circle1 = new CircleWithPatternMatcher(10);

        System.out.println("Rectangle Perimeter: %s".formatted(ShapeWithPatternMatcher.getPerimeter(rectangle1)));
        System.out.println("Circle Perimeter: %s".formatted(ShapeWithPatternMatcher.getPerimeter(circle1)));
    }
}
