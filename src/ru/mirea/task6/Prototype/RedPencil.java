package ru.mirea.task6.Prototype;

public class RedPencil extends Pencil{

    public RedPencil() {
        this.colorName="red";
    }

    @Override
    void addColor() {
        System.out.println("Drawing red");
    }
}
