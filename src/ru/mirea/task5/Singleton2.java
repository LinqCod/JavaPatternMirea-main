package ru.mirea.task5;

//пример из методички
public enum Singleton2 {
    INSTANCE;
    public static Singleton2 getInstance() {
        return INSTANCE;
    }
}
