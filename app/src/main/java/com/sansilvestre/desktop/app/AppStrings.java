package com.sansilvestre.desktop.app;

import java.util.ResourceBundle;

public class AppStrings {

    private static final String APP_FILE = "AppStrings";
    private static final String APP_ROUTE = Language.getStringLanguage() + APP_FILE; // By default /strings/es/App

    public static final ResourceBundle APP_STRINGS = ResourceBundle.getBundle(APP_ROUTE);

    private static final String FINISH_BUTTON = "finishButton";
    private static final String GO_BACK_BUTTON = "goBackButton";

    public static String getDefaultText() {
        return "";
    }

    public static String getAppName() {
        return APP_STRINGS.getString("appName");
    }

    public static String getLoginButton() {
        return APP_STRINGS.getString("signInButton");
    }

    public static String getAddButton() {
        return APP_STRINGS.getString("addButton");
    }

    public static String getUpdateButton() {
        return APP_STRINGS.getString("updateButton");
    }

    public static String getDeleteButton() {
        return APP_STRINGS.getString("deleteButton");
    }

    public static String getFinishButton() {
        return APP_STRINGS.getString(FINISH_BUTTON);
    }

    public static String getGoBackButton() {
        return APP_STRINGS.getString(GO_BACK_BUTTON);
    }

}