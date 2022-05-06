package ru.mirea.task10.components;

import ru.mirea.task10.interfaces.Knight;

public class StrongKnight implements Knight {
    @Override
    public void fight() {
        System.out.println("Strong Knight fight");
    }
}
