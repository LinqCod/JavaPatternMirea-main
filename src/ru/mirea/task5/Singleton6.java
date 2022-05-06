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
public class Singleton6 {
    private Singleton6() {
    }

    private static class SingletonHolder {
        public static final Singleton6 HOLDER_INSTANCE = new Singleton6();
    }

    public static Singleton6 getInstance() {
        return SingletonHolder.HOLDER_INSTANCE;
    }

}
