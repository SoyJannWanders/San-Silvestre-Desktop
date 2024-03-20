package com.sansilvestre.desktop.app.auth.screens.resources;

import com.sansilvestre.desktop.app.Language;

import java.util.ResourceBundle;

public class AuthStrings {

    private static final String AUTH_BUNDLE = Language.getSystemLanguage() + "AuthStrings";

    private static final ResourceBundle AUTH_STRINGS = ResourceBundle.getBundle(AUTH_BUNDLE);

    public static String getDefaultText() {
        return "";
    }

    public static String getHeadline() {
        return AUTH_STRINGS.getString("headline");
    }

    public static String getBody() {
        return AUTH_STRINGS.getString("body");
    }

    public static String getEmailLabel() {
        return AUTH_STRINGS.getString("emailLabel");
    }

    public static String getEmailPlaceholder() {
        return AUTH_STRINGS.getString("emailPlaceholder");
    }

    public static String getPasswordLabel() {
        return AUTH_STRINGS.getString("passwordLabel");
    }

    public static String getPasswordPlaceholder() {
        return AUTH_STRINGS.getString("passwordPlaceholder");
    }

    public static String getLaunchScreenLabel() {
        return AUTH_STRINGS.getString("launchScreenLabel");
    }

    public static String getLaunchScreenButton() {
        return AUTH_STRINGS.getString("launchScreenButton");
    }

}