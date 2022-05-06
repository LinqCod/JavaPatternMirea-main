package ru.mirea.task6.Builder;

/**
 * Директор знает в какой последовательности заставлять работать строителя. Он
 * работает с ним через общий интерфейс Строителя. Из-за этого, он может не
 * знать какой конкретно продукт сейчас строится.
 */

public class DirectorHouse {
    public void constructSimpleHouse(Builder builder){
        builder.setFrame(true);
        builder.setRooms(5);
        //builder.setGarage(false);
    }
    public void constructGarageHouse(Builder builder){
        builder.setFrame(true);
        builder.setRooms(5);
        builder.setGarage(true);
    }
    public void onlyGarage(Builder builder){
        //builder.setFrame(true);
        //builder.setRooms(5);
        builder.setGarage(true);
    }
}
