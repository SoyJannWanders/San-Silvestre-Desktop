package com.sansilvestre.desktop.app;

import java.util.ResourceBundle;

public class Theme {

    public static final String DEFAULT_THEMES_ROUTE = "themes.default";

    private static final String SILVESTRY_THEME_ROUTE = "themes.Silvestry";

    private static final ResourceBundle THEME = ResourceBundle.getBundle(SILVESTRY_THEME_ROUTE);

    private static final String HEADLINE_SMALL = "headlineSmall";
    private static final String LABEL_SMALL = "labelSmall";
    private static final String LABEL_MEDIUM = "labelMedium";
    private static final String LABEL_LARGE = "labelLarge";

    private static final String TEXT_BUTTON = "textButton";
    private static final String DELETE_BUTTON = "deleteButton";

    public static String applyDefaultStyle() {
        return "";
    }

    public static String applyLogoStyle() {
        return THEME.getString("logo");
    }

    public static String applyHeadlineStyle() {
        return THEME.getString("headline");
    }

    public static String applyHeadlineSmallStyle() {
        return THEME.getString(HEADLINE_SMALL);
    }

    public static String applyLabelSmallStyle() {
        return THEME.getString(LABEL_SMALL);
    }

    public static String applyLabelMediumStyle() {
        return THEME.getString(LABEL_MEDIUM);
    }

    public static String applyLabelLargeStyle() {
        return THEME.getString(LABEL_LARGE);
    }

    public static String applySectionStyle() {
        return THEME.getString("section");
    }

    public static String applyBodyStyle() {
        return THEME.getString("body");
    }

    public static String applySupportingTextStyle() {
        return THEME.getString("supportingText");
    }

    public static String applySupportingButtonStyle() {
        return THEME.getString("supportingButton");
    }

    public static String applyConteinerStyle() {
        return THEME.getString("conteiner");
    }

    public static String applyTextButtonStyle() {
        return THEME.getString(TEXT_BUTTON);
    }

    public static String applyDeleteButtonStyle() {
        return THEME.getString(DELETE_BUTTON);
    }

}