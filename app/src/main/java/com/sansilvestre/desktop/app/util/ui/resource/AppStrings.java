package com.sansilvestre.desktop.app.util.ui.resource;

import com.sansilvestre.desktop.app.util.ui.accessibility.Language;

import java.util.ResourceBundle;

public class AppStrings {

    public enum Screen {
        ALL,
        LAUNCH,
        OPEN_SESSION,
        CHECKOUT
    }

    private static final String APP_FILE = "App";
    private static final String APP_ROUTE = Language.getStringLanguage() + APP_FILE; // By default /strings/es/App

    public static final ResourceBundle APP_STRINGS = ResourceBundle.getBundle(APP_ROUTE);

    private static final String ADVANCED_OPTIONS_BUTTON = "delete.other";

    private static final String FINISH_BUTTON = "finishButton";
    private static final String GO_BACK_BUTTON = "goBackButton";

    public static String get(String key) {
        return APP_STRINGS.getString(key);
    }

    public static String get(Screen screen, String key) {
        return switch (screen) {
            case ALL -> ResourceBundle.getBundle(Language.getStringLanguage() + "App").getString(key);
            case LAUNCH -> ResourceBundle.getBundle(Language.getStringLanguage() + "launch.Launch").getString(key);
            case OPEN_SESSION -> ResourceBundle.getBundle(Language.getStringLanguage() + "session.open").getString(key);
            case CHECKOUT -> ResourceBundle.getBundle(Language.getStringLanguage() + "checkout.checkout").getString(key);
        };
    }

    public static String getDefaultText() {
        return "";
    }

    public static String getAppName() {
        return APP_STRINGS.getString("app.name");
    }

    public static String getLoginButton() {
        return APP_STRINGS.getString("button.login");
    }

    public static String getAddButton() {
        return APP_STRINGS.getString("button.add");
    }

    public static String getUpdateButton() {
        return APP_STRINGS.getString("button.update");
    }

    public static String getDeleteButton() {
        return APP_STRINGS.getString("button.delete");
    }

    public static String getAdvancedOptionsButton() {
        return APP_STRINGS.getString(ADVANCED_OPTIONS_BUTTON);
    }

    public static String getFinishButton() {
        return APP_STRINGS.getString(FINISH_BUTTON);
    }

    public static String getGoBackButton() {
        return APP_STRINGS.getString(GO_BACK_BUTTON);
    }

}