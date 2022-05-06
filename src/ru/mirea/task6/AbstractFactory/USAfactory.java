package ru.mirea.task6.AbstractFactory;

public class USAfactory implements AbstractFactoryWar{
    @Override
    public Tank createTank() {
        return new USAtank();
    }

    @Override
    public Plane createPlane() {
        return new USAplane();
    }
}
