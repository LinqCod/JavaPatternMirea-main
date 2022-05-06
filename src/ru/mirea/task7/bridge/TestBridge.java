package ru.mirea.task7.bridge;

public class TestBridge {
    public static void main(String[] args) {
        testShape(new BlackColor());
        testShape(new WhiteColor());
        testShape(new Yellow());

    }
    public static void testShape(Color color) {
        Triangle triangle = new Triangle(color);
        triangle.draw();

        Rectangle rectangle = new Rectangle(color);
        rectangle.draw();
        System.out.println();
    }
}
