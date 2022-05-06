package ru.mirea.task5;

//cамая простая реализация
/**
 * Плюсы:
 * Ленивая инициализация.
 *
 * Потокобезопасность
 *
 * Высокая производительность в многопоточной среде
 *
 * Минусы:
 * Не поддерживается на версиях Java ниже 1.5 (в версии 1.5 исправили работу ключевого слова volatile)
 *
 * Важно, что для корректной работы данного варианта реализации обязательно одно из двух условий.
 * Переменная INSTANCE должна быть либо final, либо volatile.
 * */
public class Singleton5 {
    private static Singleton5 INSTANCE;

    private Singleton5() {
    }

    public static Singleton5 getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton5.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton5();
                }
            }
        }
        return INSTANCE;
    }

}
