package ru.mirea.task5;

/**
 * Синглтон — это шаблон (паттерн) проектирования, который делает две вещи:
 * Дает гарантию, что у класса будет всего один экземпляр класса.
 *
 * Предоставляет глобальную точку доступа к экземпляру данного класса.
 *
 * Отсюда — две особенности, характерные для практически каждой реализации паттерна синглтон:
 * Приватный конструктор. Ограничивает возможность создания объектов класса за пределами самого класса.
 *
 * Публичный статический метод, который возвращает экземпляр класса.
 * Данный метод называют getInstance. Это глобальная точка доступа к экземпляру класса.
 * */
public class TestSingleton {
    public static void main(String[] args) {
        Singleton1 s1 =Singleton1.getInstance();
        Singleton1 s1e = Singleton1.getInstance();
        System.out.println(s1+" "+s1e+" "+s1.equals(s1e));

        Singleton2 s2 = Singleton2.getInstance();
        Singleton2 s2e = Singleton2.getInstance();
        System.out.println(s2+" "+s2e+" "+s2.equals(s2e));

        Singleton3 s3 = Singleton3.getInstance();
        Singleton3 s3e = Singleton3.getInstance();
        System.out.println(s3+" "+s3e+" "+s3.equals(s3e));

        Singleton4 s4 = Singleton4.getInstance();
        Singleton4 s4e = Singleton4.getInstance();
        System.out.println(s4+" "+s4e+" "+s4.equals(s4e));

        Singleton5 s5 = Singleton5.getInstance();
        Singleton5 s5e = Singleton5.getInstance();
        System.out.println(s5+" "+s5e+" "+s5.equals(s5e));

        Singleton6 s6 = Singleton6.getInstance();
        Singleton6 s6e = Singleton6.getInstance();
        System.out.println(s6+" "+s6e+" "+s6.equals(s6e));

    }
}
