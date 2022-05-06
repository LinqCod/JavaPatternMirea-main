package ru.mirea.task5;

//cамая простая реализация
/**
 * Плюсы:
 * Простота и прозрачность кода
 * Потокобезопасность
 * Высокая производительность в многопоточной среде
 *
 * Минусы:
 * Не ленивая инициализация.
 * */
public class Singleton3 {
    private static final Singleton3 INSTANCE = new Singleton3();

    private Singleton3() {
    }

    public static Singleton3 getInstance() {
        return INSTANCE;
    }

}
