package ru.mirea.task2;

import java.util.List;
import java.util.stream.Stream;

public class TestHuman {
    public static void main(String[] args) {

        //можно через static
        HumanApp humanApp = new HumanApp();
        Stream<Human> listHuman =  humanApp.getHumans();
        humanApp.printHuman(listHuman);

        HumanApp humanApp1 = new HumanApp();
        Stream<Human> listHuman1 =  humanApp1.getHumans();
        System.out.println(humanApp1.getSumAge(listHuman1));

        HumanApp humanApp2 = new HumanApp();
        Stream<Human> listHuman2 =  humanApp2.getHumans();
        humanApp2.sortByName(listHuman2);

        System.out.println();
        HumanApp humanApp3 = new HumanApp();
        Stream<Human> listHuman3 =  humanApp3.getHumans();
        humanApp3.sortBySurName(listHuman3);
    }
}
