package ru.mirea.task6.Builder;

public class TestBuilder {
    public static void main(String[] args) {

        DirectorHouse directorHouse=new DirectorHouse();
        HouseBuilder houseBuilder=new HouseBuilder();
        directorHouse.constructSimpleHouse(houseBuilder);
        House house = houseBuilder.getResult();
        System.out.println(house.getRooms());
        System.out.println(house);

        HouseBuilder houseBuilder2=new HouseBuilder();
        directorHouse.constructGarageHouse(houseBuilder2);
        House house2 = houseBuilder2.getResult();
        System.out.println(house2.getRooms());
        System.out.println(house2);

        HouseBuilder houseBuilder3=new HouseBuilder();
        directorHouse.onlyGarage(houseBuilder3);
        House house3 = houseBuilder3.getResult();
        System.out.println(house3.getRooms());
        System.out.println(house3);

    }
}
