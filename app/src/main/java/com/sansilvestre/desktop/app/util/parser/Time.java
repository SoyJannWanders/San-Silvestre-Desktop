package com.sansilvestre.desktop.app.util.parser;

import java.time.LocalTime;

public class Time {

    public static LocalTime valueOf(Object o) {
        String time = o.toString();
        String hours = time.substring(0, 2);
        String minutes = time.substring(3, 5);
        return LocalTime.of(Integer.parseInt(hours), Integer.parseInt(minutes));
    }

}