package com.sansilvestre.desktop.app.util.formatter;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Percentage {

    public static final String PATTERN = "#,###.##";
    public static final String GROUPING_SEPARATOR = ".";
    public static final String DECIMAL_SEPARATOR = ",";

    public static String format(String in) {
        String raw = removeFormat(in);
        if (raw.isEmpty()) {
            return raw;
        } else {
            if (raw.charAt(raw.length() - 1) != ',') {
                raw = raw.replace(Currency.DECIMAL_SEPARATOR, Currency.GROUPING_SEPARATOR);
                return format(Double.parseDouble(raw));
            } else {
                return raw + "%";
            }
        }
    }

    public static String format(double percentage) {
        if (percentage != 0)
            return new DecimalFormat(PATTERN, getDecimalFormatSymbols()).format(percentage) + "%";
        else
            return "0%";
    }

    public static String removeFormat(String textFormatted) {
        return textFormatted.replace(".", "").replace("%", "");
    }

    public static double toDouble(String textFormatted) {
        textFormatted = textFormatted.replace(".", "").replace(",", ".");
        return removeFormat(textFormatted).isEmpty() ? 0 : Double.parseDouble(removeFormat(textFormatted));
    }

    private static DecimalFormatSymbols getDecimalFormatSymbols() {
        DecimalFormatSymbols format = new DecimalFormatSymbols(Locale.getDefault());
        format.setGroupingSeparator(GROUPING_SEPARATOR.charAt(0));
        format.setDecimalSeparator(DECIMAL_SEPARATOR.charAt(0));
        return format;
    }

}