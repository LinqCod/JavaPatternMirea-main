package ru.mirea.task6.AbstractFactory;

public class TestAbsrtactFactory {
    public static void main(String[] args) {
        RussianFactory russianFactory=new RussianFactory();
        Plane il76 = russianFactory.createPlane();
        il76.shoot();
        Tank armata = russianFactory.createTank();
        armata.shoot();

        USAfactory usaFactory=new USAfactory();
        Plane eagle = usaFactory.createPlane();
        eagle.shoot();
        Tank sherman = usaFactory.createTank();
        sherman.shoot();
    }
}
