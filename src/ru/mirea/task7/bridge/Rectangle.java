package ru.mirea.task7.bridge;

public class Rectangle extends Shape{
    public Rectangle(Color color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.println("It's rectangle");
        this.color.fillColor();
    }
}
