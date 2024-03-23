package com.sansilvestre.desktop.app;

public class Input {

    public static boolean isValidInput(String input) {
        return !input.isEmpty() && !input.isBlank();
    }

}