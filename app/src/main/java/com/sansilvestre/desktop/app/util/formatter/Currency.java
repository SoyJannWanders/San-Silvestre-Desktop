package com.sansilvestre.desktop.app.util.formatter;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Currency {

    public static final String PATTERN = "#,###.##";
    public static final String GROUPING_SEPARATOR = ".";
    public static final String DECIMAL_SEPARATOR = ",";

    private static final String LEADING_ICON = "$ ";

    public static String format(String in) {
        String rawInput = removeFormat(in);
        if (rawInput.isEmpty()) {
            return rawInput;
        } else {
            if (rawInput.charAt(rawInput.length() - 1) != ',') {
                rawInput = rawInput.replace(Currency.DECIMAL_SEPARATOR, Currency.GROUPING_SEPARATOR);
                return format(Double.parseDouble(rawInput));
            } else {
                return in;
            }
        }
    }

    public static String format(Double value) {
        if (value != 0)
            return LEADING_ICON + new DecimalFormat(PATTERN, getDecimalFormatSymbols()).format(value);
        else
            return LEADING_ICON + 0;

    }

    public static String removeFormat(String formattedNumber) {
        return formattedNumber
                .replace(LEADING_ICON, "")
                .replace("$", "")
                .replace(GROUPING_SEPARATOR, "");
    }

    public static double toDouble(String textFormatted) {
        String raw = removeFormat(textFormatted);
        raw = raw.replace(Currency.DECIMAL_SEPARATOR, Currency.GROUPING_SEPARATOR);
        return raw.isEmpty() ? 0 : Double.parseDouble(raw);
    }

    private static DecimalFormatSymbols getDecimalFormatSymbols() {
        DecimalFormatSymbols format = new DecimalFormatSymbols(Locale.getDefault());
        format.setGroupingSeparator(GROUPING_SEPARATOR.charAt(0));
        format.setDecimalSeparator(DECIMAL_SEPARATOR.charAt(0));
        return format;
    }

}