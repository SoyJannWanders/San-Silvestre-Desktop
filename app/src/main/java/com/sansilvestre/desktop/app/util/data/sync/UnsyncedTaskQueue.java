package com.sansilvestre.desktop.app.util.data.sync;

import com.sansilvestre.desktop.app.util.data.sync.AsyncTaskManager;

import java.util.LinkedList;
import java.util.Queue;

public class UnsyncedTaskQueue {

    private final Queue<Runnable> unsyncedTaskQueue = new LinkedList<>();

    private boolean isRunning = false;

    public synchronized void add(Runnable task) {
        unsyncedTaskQueue.add(task);
        if (!isRunning) {
            isRunning = true;
            executeNextTask();
        }
    }

    private synchronized void executeNextTask() {
        if (unsyncedTaskQueue.isEmpty()) {
            isRunning = false;
        } else {
            Runnable nextTask = unsyncedTaskQueue.poll();
            AsyncTaskManager.executeAsync(() -> {
                try {
                    nextTask.run();
                } finally {
                    executeNextTask();
                }
            });
        }
    }

}