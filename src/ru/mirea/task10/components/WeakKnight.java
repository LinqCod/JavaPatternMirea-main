package ru.mirea.task10.components;

import ru.mirea.task10.interfaces.Knight;

public class WeakKnight implements Knight {

    @Override
    public void fight() {
        System.out.println("Weak Knight fight");
    }
}
