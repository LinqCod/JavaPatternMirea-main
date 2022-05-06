package ru.mirea.task7.adapter.simple;

public class MemoryCard implements WorkWithMemoryCard{

    public void insert() {
        System.out.println("Карта памяти вставлена");
    }

    public void copyData() {
        System.out.println("Данные скопированы");
    }
    public void drag() {
        System.out.println("Карта памяти вытащена");
    }
}
