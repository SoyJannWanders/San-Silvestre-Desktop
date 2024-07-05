package com.sansilvestre.desktop.app.util.formatter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Date {

    public static String now() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy · HH:mm");
        return LocalDateTime.now().format(formatter);
    }

    public static String formatDateTime(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy · HH:mm");
        return dateTime.format(formatter);
    }

}