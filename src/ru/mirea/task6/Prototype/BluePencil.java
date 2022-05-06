package ru.mirea.task6.Prototype;

public class BluePencil extends Pencil{

    public BluePencil() {
        this.colorName="blue";
    }

    @Override
    void addColor() {
        System.out.println("Drawing blue");
    }
}
