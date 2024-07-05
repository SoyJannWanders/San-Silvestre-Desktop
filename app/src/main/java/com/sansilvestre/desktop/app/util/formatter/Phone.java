package com.sansilvestre.desktop.app.util.formatter;

public class Phone {

    public static String formatPhoneNumber(String in) {
        if (in.equals("(")) {
            in = "";
        } else if (in.length() == 1) {
            in = "(" + in;
        } else if (in.length() == 6) {
            in = in.substring(0, in.length() - 2);
        } else if (in.length() == 5) {
            char c = in.charAt(in.length() - 1);
            in = in.substring(0, in.length() - 1) + ") " + c;
        } else if (in.length() == 8 && in.charAt(in.length() - 1) == ' ') {
            in = in.substring(0, in.length() - 1);
        } else if (in.length() == 8) {
            char c = in.charAt(in.length() - 1);
            in = in.substring(0, in.length() - 1) + " " + c;
        }
        return in;
    }

}