package ru.mirea.task3;

class MyFirstThread extends Thread{
    @Override
    public void run() {
        System.out.println("I'm Thread! My name is " + getName());
    }
}
/*
public class TempTest {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {

             * Создаем 10 потоков (объектов) MyFirstThread, который наследуется от Thread и запускаем их,
             * вызывая у объекта метод start(). После вызова метода start() начинает работу его метод run(),
             * и выполняется та логика, которая была в нем написана.
             *
            MyFirstThread thread = new MyFirstThread();
            thread.start();
            *
             * В каком порядке их запускать — решает планировщик потоков: особый механизм внутри операционной системы.
             * Последовательность выполнения потоков программист контролировать не может.
             *
        }
    }
}*/

class EggVoice extends Thread
{
    @Override
    public void run()
    {
        for(int i = 0; i < 5; i++)
        {
            try{
                sleep(1000);		//Приостанавливает поток на 1 секунду
            }catch(InterruptedException e){}

            System.out.println("яйцо!");
        }
        //Слово «яйцо» сказано 5 раз
    }
}

class ChickenVoice	//Класс с методом main()
{
    static EggVoice mAnotherOpinion;	//Побочный поток

    public static void main(String[] args)
    {
        mAnotherOpinion = new EggVoice();	//Создание потока
        System.out.println("Спор начат...");
        mAnotherOpinion.start(); 			//Запуск потока

        for(int i = 0; i < 5; i++)
        {
            try{
                Thread.sleep(1000);		//Приостанавливает поток на 1 секунду
            }catch(InterruptedException e){}

            System.out.println("курица!");
        }

        //Слово «курица» сказано 5 раз

        if(mAnotherOpinion.isAlive())	//Если оппонент еще не сказал последнее слово
        {
            try{
                mAnotherOpinion.join();	//Подождать пока оппонент закончит высказываться.
            }catch(InterruptedException e){}

            System.out.println("Первым появилось яйцо!");
        }
        else	//если оппонент уже закончил высказываться
        {
            System.out.println("Первой появилась курица!");
        }
        System.out.println("Спор закончен!");
    }
}