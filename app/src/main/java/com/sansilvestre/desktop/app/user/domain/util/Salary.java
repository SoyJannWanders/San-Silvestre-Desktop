package com.sansilvestre.desktop.app.user.domain.util;

import com.sansilvestre.desktop.app.util.formatter.Currency;

public class Salary {

    public static String calculate(String in) {
        String raw = Currency.removeFormat(in);
        raw = raw.replace(Currency.DECIMAL_SEPARATOR, Currency.GROUPING_SEPARATOR);
        if (raw.isEmpty()) {
            return "$ 0,00";
        } else {
            double d = Double.valueOf(raw);
            d = d * 5;
            return Currency.format(d);
        }
    }

    public static String calculate(double salary) {
        salary = salary * 5;
        return Currency.format(salary);
    }

}