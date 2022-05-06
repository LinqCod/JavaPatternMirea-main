package ru.mirea.task3;

import java.util.*;
import java.util.concurrent.Semaphore;

public class Teask3Test {

    //для мэпа синхронизированного
    public static class myThread1 extends  Thread{
        Map<String, Integer> map;

        public myThread1(Map<String, Integer> map) {
            this.map = map;
        }

        @Override
        public void run() {
            synchronized (map){
                System.out.println("Thread "+ Thread.currentThread().getName()+" is started");
                map.put("keyFirst",1);
                System.out.println(Thread.currentThread().getName()+" keyFirst was add");
                map.put("keySecond",2);
                System.out.println(Thread.currentThread().getName()+" keySecond was add");

            }
        }
    }
    //для семафорноголиста
    public static class myThread2 extends  Thread{
        private static final Semaphore semaphore = new Semaphore(1);//почекать почему именно так стало работать
        List<Integer> integerList;

        public myThread2(List<Integer> integerList) {
            this.integerList = integerList;
        }

        @Override
        public void run() {
            try {
                System.out.println("Thread "+ Thread.currentThread().getName()+" is starned");
                semaphore.acquire();
                for (int i = 0; i < 10; i++)
                {
                    integerList.add(i);
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                }

            } catch (InterruptedException er) {
                er.printStackTrace();
            }
            finally {
                semaphore.release();
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Thread one = new myThread2(list);
        one.setName("Thread1");
        Thread two = new myThread2(list);
        two.setName("Thread2");
        System.out.println("Задание 1:");
        //чтобы не было траблов с потоками - запускаем через закоменчивание
        one.start();
        two.start();

        //вторая часть задания
        Map map = new HashMap();

        Thread three = new myThread1(map);
        three.setName("Thread3");

        Thread four = new myThread1(map);
        four.setName("Thread4");
        System.out.println("Задание 2:");
        //чтобы не было трабблов с потоками - закоменчиваем
        //three.start();
        //four.start();
    }
}
