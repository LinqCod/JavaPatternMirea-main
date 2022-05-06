package ru.mirea.task4;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * При запуске задач с помощью Executor  не требуется прибегать к низкоуровневой поточной функциональности класса Thread,
 * достаточно создать объект типа ExecutorService с нужными свойствами и передать ему на исполнение задачу типа Callable.
 * Впоследствии можно легко просмотреть результат выполнения этой задачи с помощью объекта Future.
 * */

public class TestExecutorService {
    public static void main(String[] args) {
        Callable<String> task = () -> Thread.currentThread().getName();//это реализует аналог раннэбл, необходимый для запуска потока
        MyExecutorService service = new MyExecutorService(2);//создаем наш имплементированный экземпляр
        for (int i = 0; i < 5; i++) {
            Future result = service.submit(task);//	Завершение выполнения задачи, возвращающей результат в виде объекта Future
            try {
                System.out.println(result.get());//печать реза
                //дальше ловим два типа ошибок
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        service.shutdown();//	Упорядоченное завершение работы, при котором ранее отправленные задачи выполняются, а новые задачи не принимаются
    }
}
