package com.sansilvestre.desktop.app.product.create.domain.util;

public class Rounder {

    public static double round(double value) {
        double rest;
        if (value < 1000) { // Unit Rounding
            rest = value % 10;
            if (rest >= 4)
                return value - rest + 10;
            else
                return value - rest;
        } else if (value < 100000) { // Rounding Tens
            rest = value % 100;
            if (rest >= 40)
                return value - rest + 100;
            else
                return value - rest;
        } else
            return value;
    }

}