package ru.mirea.task6.AbstractFactory;

public class RussianFactory implements AbstractFactoryWar{
    @Override
    public Tank createTank() {
        return new RussianTank();
    }

    @Override
    public Plane createPlane() {
        return new RussianPlane();
    }
}
