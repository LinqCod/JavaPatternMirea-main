package ru.mirea.task6.AbstractFactory;

public class USAplane implements Plane{
    @Override
    public void shoot() {
        System.out.println("USA's plane shoot");
    }
}
