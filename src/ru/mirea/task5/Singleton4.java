package ru.mirea.task5;

//cамая простая реализация
/**
 * Плюсы:
 * Ленивая инициализация.
 *
 * Минусы:
 * Не потокобезопасно
 *
 * Реализация интересна. Мы можем инициализироваться лениво, но утратили потокобезопасность.
 * */
public class Singleton4 {
    private static Singleton4 INSTANCE;

    private Singleton4() {}

    public static Singleton4 getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton4();
        }
        return INSTANCE;
    }

}
