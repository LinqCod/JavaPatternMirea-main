package ru.mirea.task3;

import java.util.List;

public class TestListSem {
    private List<Integer> listSync = new ListSemaph<>();


    public void testing(){

        Thread thread1 = new Thread(() -> {
            for (int i = 1; i < 21; i++) {
                listSync.add(i);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 21; i < 41; i++) {
                listSync.add(i);
            }
        });

        thread1.start();
        thread2.start();

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Sync list:");
        listSync.forEach(System.out::println);
    }

}
