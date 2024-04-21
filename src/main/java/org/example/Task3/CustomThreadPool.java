package org.example.Task3;

import java.util.LinkedList;
import java.util.Queue;

public class CustomThreadPool {
    private final Queue<Runnable> tasks = new LinkedList<>();
    private final Thread[] threads;
    private volatile boolean isShutdown = false;

    public CustomThreadPool(int numThreads) {
        threads = new Thread[numThreads];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                while (!isShutdown) {
                    Runnable task;
                    synchronized (tasks) {
                        while (tasks.isEmpty() && !isShutdown) {
                            try {
                                tasks.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        if (isShutdown && tasks.isEmpty()) {
                            break;
                        }
                        task = tasks.poll();
                    }
                    try {
                        task.run();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            threads[i].start();
        }
    }

    public void execute(Runnable task) {
        if (isShutdown) {
            throw new IllegalStateException("Уже выключен");
        }
        synchronized (tasks) {
            tasks.add(task);
            tasks.notifyAll();
        }
    }

    public void shutDown() {
        isShutdown = true;
        synchronized (tasks) {
            tasks.notifyAll();
        }
    }
}
