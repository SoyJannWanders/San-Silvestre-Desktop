package com.sansilvestre.desktop.app.product.main.data.source.remote;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SyncTask {

    private static final ExecutorService resources = Executors.newFixedThreadPool(8);

    private SyncTask() {}

    public static ExecutorService getInstance() {
        return resources;
    }

    public static void shutdown() {
        resources.shutdown();
    }

}