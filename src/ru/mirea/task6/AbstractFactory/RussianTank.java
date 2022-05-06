package ru.mirea.task6.AbstractFactory;

public class RussianTank implements Tank{
    @Override
    public void shoot() {
        System.out.println("Russian's tank shoot");
    }
}
