package com.sansilvestre.desktop.app;

public class Language {

    private static final String SYSTEM_LANGUAGE = "es";
    private static final String STRING_LANGUAGE = "strings." + SYSTEM_LANGUAGE + ".";

    public static String getSystemLanguage() {
        return SYSTEM_LANGUAGE;
    }

    public static String getStringLanguage() {
        return STRING_LANGUAGE;
    }

}