package ru.mirea.task2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/*
Сортировка по имени                                     -
фильтрация по дате рождения большей, чем 24 июня 2000   -done
сортировка по фамилии                                   -
нахождение суммы всех возрастов                         -done
*/
public class HumanApp {
    private Stream<Human> temp;

    //получить список людей
    //убрал static
    public  Stream<Human> getHumans(){
        List<Human> input = new ArrayList<>();
        input.add(new Human(20,"Ben","Afflec", LocalDate.of(2000,01,01),50));
        input.add(new Human(40,"Fil","Red", LocalDate.of(1993,04,10),55));
        input.add(new Human(15,"Van","Black", LocalDate.of(1992,11,06),40));
        input.add(new Human(35,"Soul","White", LocalDate.of(2005,05,03),60));
        input.add(new Human(30,"Vesemir","Yellow", LocalDate.of(1994,02,01),550));
        Stream<Human> stream = input.stream();
        return  stream;
    }

    //получить суммарный возраст
    public int getSumAge(Stream<Human> temp){
        int summa= temp.mapToInt(Human::getAge).sum();//предложила идея
        return summa;
    }

    //фильтрация по дате рождения большей, чем 24 июня 2000
    public Stream<Human> filterByData(Stream<Human> temp){
        return temp.filter(human -> human.getBirthDate().isBefore(LocalDate.of(2000,06,24) ));//.collect(Collectors.toList());
    }

    //вывод на экран
    public void printHuman(Stream<Human> temp) {
        temp.forEach(System.out::println);
    }

    //сортировка по имени
    public void sortByName(Stream<Human> temp){
        temp.sorted((human1,human2)->{
            return (human1.getFirstName().compareTo(human2.getFirstName()));
        }).forEach(System.out::println);
    }

    //сортировка по имени
    public void sortBySurName(Stream<Human> temp){
        temp.sorted((human1,human2)->{
            return (human1.getLastName().compareTo(human2.getLastName()));
        }).forEach(System.out::println);
    }
}
