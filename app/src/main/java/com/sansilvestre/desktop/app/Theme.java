package com.sansilvestre.desktop.app;

import java.util.ResourceBundle;

public class Theme {

    public static final String DEFAULT_THEMES_FOLDER = "themes/default/";

    private static final String APP_THEME = "themes/silvestry";

    private static final ResourceBundle APP_BUNDLE = ResourceBundle.getBundle(APP_THEME);

    public static String applyDefaultStyle() {
        return "";
    }

    public static String applyLogoStyle() {
        return APP_BUNDLE.getString("logo");
    }

    public static String applyHeadlineStyle() {
        return APP_BUNDLE.getString("headline");
    }

    public static String applyBodyStyle() {
        return APP_BUNDLE.getString("body");
    }

    public static String applySupportingTextStyle() {
        return APP_BUNDLE.getString("supportingText");
    }

    public static String applySupportingButtonStyle() {
        return APP_BUNDLE.getString("supportingButton");
    }

    public static String applyConteinerStyle() {
        return APP_BUNDLE.getString("conteiner");
    }
    
}