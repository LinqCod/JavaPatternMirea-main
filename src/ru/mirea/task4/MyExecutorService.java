package ru.mirea.task4;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

/**
 * В многопоточный пакет concurrent для управления потоками включено средство, называемое сервисом исполнения ExecutorService.
 * Данное средство служит альтернативой классу Thread, предназначенному для управления потоками.
 * В основу сервиса исполнения положен интерфейс Executor, в котором определен один метод.
 * */

//Реализовать собственную имплементацию ExecutorService с
//единственным параметром конструктора – количеством потоков.

public class MyExecutorService implements ExecutorService {

    private ExecutorService executorService;

    public MyExecutorService(int numberOfThreads) {
        this.executorService = Executors.newFixedThreadPool(numberOfThreads);
    }

    @Override
    public void shutdown() {
        executorService.shutdown();
    }

    //	Остановка всех активно выполняемых задач, остановка обработки ожидающих задач, возвращение списка задач, ожидающих выполнения
    @Override
    public List<Runnable> shutdownNow() {
        return executorService.shutdownNow();
    }

    @Override
    public boolean isShutdown() {
        return executorService.isShutdown();
    }

    @Override
    public boolean isTerminated() {
        return executorService.isTerminated();
    }

    //Блокировка до тех пор, пока все задачи не завершат выполнение после запроса на завершение работы или
    // пока не наступит тайм-аут или не будет прерван текущий поток, в зависимости от того, что произойдет раньше
    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return executorService.awaitTermination(timeout,unit);
    }

    //Завершение выполнения задачи, возвращающей результат в виде объекта Future
    @Override
    public <T> Future<T> submit(Callable<T> task) {
        return executorService.submit(task);
    }

    @Override
    public <T> Future<T> submit(Runnable task, T result) {
        return executorService.submit(task,result);
    }

    @Override
    public Future<?> submit(Runnable task) {
        return executorService.submit(task);
    }

    //Выполнение задач с возвращением списка задач с их статусом и результатами завершения
    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
        return executorService.invokeAll(tasks);
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException {
        return executorService.invokeAll(tasks, timeout,unit);
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
        return executorService.invokeAny(tasks);
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return executorService.invokeAny(tasks,timeout,unit);
    }

    @Override
    public void execute(Runnable command) {

        executorService.execute(command);
    }
}
