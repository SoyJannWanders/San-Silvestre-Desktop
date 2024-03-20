package com.sansilvestre.desktop.app.launch.screens.resources;

import com.sansilvestre.desktop.app.Language;

import java.util.ResourceBundle;

public class LaunchStrings {

    private static final String LAUNCH_BUNDLE = Language.getSystemLanguage() + "LaunchStrings";

    public static final ResourceBundle LAUNCH_STRINGS = ResourceBundle.getBundle(LAUNCH_BUNDLE);

    public static String getHeadline() {
        return LAUNCH_STRINGS.getString("headline");
    }

    public static String getBody() {
        return LAUNCH_STRINGS.getString("body");
    }

    public static String getScheduleLabel() {
        return LAUNCH_STRINGS.getString("scheduleLabel");
    }

    public static String getEmployeeScreenButton() {
        return LAUNCH_STRINGS.getString("employeeScreenButton");
    }

    public static String getAuthScreenLabel() {
        return LAUNCH_STRINGS.getString("authScreenLabel");
    }

    public static String getAuthScreenButton() {
        return LAUNCH_STRINGS.getString("authScreenButton");
    }

    public static String getFirstScheduleOption() {
        return LAUNCH_STRINGS.getString("firstSchedule");
    }

    public static String getSecondScheduleOption() {
        return LAUNCH_STRINGS.getString("secondSchedule");
    }

    public static String getThirdScheduleOption() {
        return LAUNCH_STRINGS.getString("thirdSchedule");
    }

}