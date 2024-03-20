package com.sansilvestre.desktop.app;

import java.util.ResourceBundle;

public class AppStrings {

    private static final String APP_FILE = "App";
    private static final String APP_ROUTE = Language.getSystemLanguage() + APP_FILE; // By default /strings/es/App

    public static final ResourceBundle APP_STRINGS = ResourceBundle.getBundle(APP_ROUTE);

    private static final String APP_NAME_KEY = "appName";

    private static final String BUTTON_GO_KEY = "go.button";
    private static final String BUTTON_LOGIN_KEY = "authScreenButton";

    public static String getAppName() {
        return APP_STRINGS.getString(APP_NAME_KEY);
    }

    public static String getGoButton() {
        return APP_STRINGS.getString(BUTTON_GO_KEY);
    }

    public static String getLoginButton() {
        return APP_STRINGS.getString(BUTTON_LOGIN_KEY);
    }

}