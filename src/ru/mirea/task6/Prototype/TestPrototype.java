package ru.mirea.task6.Prototype;

public class TestPrototype {
    public static void main(String[] args) {
        PensilStore.getPencil("blue").addColor();
        PensilStore.getPencil("red").addColor();
        PensilStore.getPencil("blue").addColor();
        PensilStore.getPencil("red").addColor();
        PensilStore.getPencil("blue").addColor();
        PensilStore.getPencil("red").addColor();
        PensilStore.getPencil("blue").addColor();
        PensilStore.getPencil("red").addColor();
        //PensilStore.getPencil("black").addColor(); - вызывает ошибку, т.к такого нет
    }
}
