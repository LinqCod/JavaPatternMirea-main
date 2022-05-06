package ru.mirea.task6.factory;

public class TestFactoryMethod {

    public static void main(String[] args) {
        Factory roadTranstopt = new RoadCreator();
        for (int i=0;i<3;i++){
            roadTranstopt.doTransport();
        }

        Factory seaTransport = new SeaCreator();
        seaTransport.doTransport();

    }
}
