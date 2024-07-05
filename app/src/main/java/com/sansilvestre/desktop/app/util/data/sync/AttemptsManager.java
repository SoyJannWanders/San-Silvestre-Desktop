package com.sansilvestre.desktop.app.util.data.sync;

import com.sansilvestre.desktop.app.util.log.Console;
import com.sansilvestre.desktop.app.util.log.ExceptionManager;

public class AttemptsManager {

    private static final int INITIAL_DELAY = 250;
    private static final int MAX_DELAY = 16000;
    private int milliseconds = INITIAL_DELAY;

    public void retryWithDelay() {
        milliseconds = Math.min(milliseconds * 2, MAX_DELAY);
        try {
            Console.info(Console.InfoCode.I001, "RETRY: Delay - " + milliseconds / 1000);
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Console.warn(Console.WarnCode.W001, "ERROR: AttemptsManager");
            Thread.currentThread().interrupt();
            ExceptionManager.catchException(e);
        }
    }

    public void resetDelay() {
        milliseconds = INITIAL_DELAY;
    }

}