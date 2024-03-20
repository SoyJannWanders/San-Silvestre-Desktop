package com.sansilvestre.desktop.app;

import java.util.ResourceBundle;

public class AppStrings {

    private static final String APP_FILE = "AppStrings";
    private static final String APP_ROUTE = Language.getSystemLanguage() + APP_FILE; // By default /strings/es/App

    public static final ResourceBundle APP_STRINGS = ResourceBundle.getBundle(APP_ROUTE);

    public static String getAppName() {
        return APP_STRINGS.getString("appName");
    }

    public static String getLoginButton() {
        return APP_STRINGS.getString("signInButton");
    }

}