package com.sansilvestre.desktop.app.util.data.sync;

import com.sansilvestre.desktop.app.util.log.Console;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

public class AsyncTaskManager {

    private static final int THREAD_POOL_SIZE = 8;
    private static final ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
    private AsyncTaskManager() {}

    public static void executeAsync(Runnable task) {
        executorService.execute(task);
    }

    public static void setOff(JFrame parent) {
        parent.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    executorService.shutdown();
                    Console.info(Console.InfoCode.I200, "El Conjunto de Hilos ha sido cerrado correctamente.");
                } catch (Exception exception) {
                    Console.error(Console.ErrorCode.E001, "El Conjunto de Hilos no se ha cerrado correctamente. Recursos en espera.", exception);
                }
            }
        });
    }

    public static void log() {
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
        int activeCount = threadPoolExecutor.getActiveCount();
        int queueSize = threadPoolExecutor.getQueue().size();
        long completedTaskCount = threadPoolExecutor.getCompletedTaskCount();
        long totalTaskCount = threadPoolExecutor.getTaskCount();
        int poolSize = threadPoolExecutor.getPoolSize();

        // Registra las métricas en los logs
        System.out.println(LocalDateTime.now());
        System.out.println("");
        System.out.println("Active threads: " + activeCount);
        System.out.println("Queue size: " + queueSize);
        System.out.println("Completed tasks: " + completedTaskCount);
        System.out.println("Total tasks: " + totalTaskCount);
        System.out.println("Core pool size: " + threadPoolExecutor.getCorePoolSize());
        System.out.println("Maximum pool size: " + threadPoolExecutor.getMaximumPoolSize());
        System.out.println("Active count: " + threadPoolExecutor.getActiveCount());
        System.out.println("Pool size: " + threadPoolExecutor.getPoolSize());
        System.out.println("-------------------------------------------------------");
    }

}