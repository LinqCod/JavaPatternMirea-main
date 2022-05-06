package ru.mirea.task6.AbstractFactory;

public class RussianPlane implements Plane{
    @Override
    public void shoot() {
        System.out.println("Russian's plane shoot");
    }
}
