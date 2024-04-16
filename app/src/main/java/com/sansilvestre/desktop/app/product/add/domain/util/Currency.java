package com.sansilvestre.desktop.app.product.add.domain.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Currency {

    public static final String PATTERN = "#,###.##";
    public static final String GROUPING_SEPARATOR = ".";
    public static final String DECIMAL_SEPARATOR = ",";

    private static final String LEADING_ICON = "$ ";

    public static String format(Double value) {
        if (value != 0)
            return LEADING_ICON + new DecimalFormat(PATTERN, getDecimalFormatSymbols()).format(value);
        else
            return LEADING_ICON + 0;

    }

    public static String removeFormat(String formattedNumber) {
        return formattedNumber.replace(LEADING_ICON, "").replace(GROUPING_SEPARATOR, "");
    }

    private static DecimalFormatSymbols getDecimalFormatSymbols() {
        DecimalFormatSymbols format = new DecimalFormatSymbols(Locale.getDefault());
        format.setGroupingSeparator(GROUPING_SEPARATOR.charAt(0));
        format.setDecimalSeparator(DECIMAL_SEPARATOR.charAt(0));
        return format;
    }

}