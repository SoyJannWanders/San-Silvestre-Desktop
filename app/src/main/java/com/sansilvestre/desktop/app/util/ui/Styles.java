package com.sansilvestre.desktop.app.util.ui;

import com.formdev.flatlaf.FlatClientProperties;

import javax.swing.*;
import java.util.ResourceBundle;

public class Styles {

    public static final String DEFAULT_THEMES_ROUTE = "themes.default";

    private static final String SILVESTRY_THEME_ROUTE = "themes.Silvestry";

    private static final ResourceBundle THEME = ResourceBundle.getBundle(SILVESTRY_THEME_ROUTE);

    private static final String HEADLINE_SMALL = "headline.small";

    private static final String TITLE_SMALL = "titleSmall";
    private static final String TITLE_MEDIUM = "titleMedium";
    private static final String TITLE_LARGE = "titleLarge";

    private static final String LABEL_SMALL = "label.small";
    private static final String LABEL_MEDIUM = "labelMedium";
    private static final String LABEL_LARGE = "labelLarge";

    private static final String BODY_SMALL = "body.small";
    private static final String BODY_SMALL_VARIANT = "bodySmallVariant";
    private static final String BODY_LARGE = "bodyLarge";

    private static final String SECONDARY_BUTTON = "secondaryButton";

    private static final String TEXT_BUTTON = "button.text";
    private static final String DELETE_BUTTON = "button.delete";

    public static void setStyleTo(JComponent component, String key) {
        component.putClientProperty(FlatClientProperties.STYLE, THEME.getString(key));
    }

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

    public static String applyTitleSmallStyle() {
        return THEME.getString(TITLE_SMALL);
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

    public static String applyBodySmallStyle() {
        return THEME.getString(BODY_SMALL);
    }

    public static String applyBodySmallVariantStyle() {
        return THEME.getString(BODY_SMALL_VARIANT);
    }

    public static String applyBodyMediumStyle() {
        return THEME.getString("body.medium");
    }

    public static String applyBodyLargeStyle() {
        return THEME.getString(BODY_LARGE);
    }


    public static String applySectionStyle() {
        return THEME.getString("label.headline");
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
        return THEME.getString("container");
    }

    public static String applySecondaryButtonStyle() {
        return THEME.getString(SECONDARY_BUTTON);
    }

    public static String applyTextButtonStyle() {
        return THEME.getString(TEXT_BUTTON);
    }

    public static String applyDeleteButtonStyle() {
        return THEME.getString(DELETE_BUTTON);
    }

}