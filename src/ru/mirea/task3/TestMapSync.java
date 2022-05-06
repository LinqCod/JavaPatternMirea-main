package ru.mirea.task3;

import java.util.Map;

public class TestMapSync {
    private static Map<Integer, String> mapSync = new MapSync<>();
    public void testing(){

        Thread thread1 = new Thread(() -> {
            for (int i = 1; i < 21; i++) {
                mapSync.put(i,"value"+i);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 21; i < 41; i++) {
                mapSync.put(i,"value"+i);
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
        mapSync.forEach((key,value)-> System.out.println(key+": "+value));
    }
}
