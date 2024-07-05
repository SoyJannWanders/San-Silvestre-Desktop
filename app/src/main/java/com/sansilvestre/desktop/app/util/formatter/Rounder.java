package com.sansilvestre.desktop.app.util.formatter;

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

    public static double roundByCash(double value) {

        // Variables para los billetes
        int bill20000 = 20000;
        int bill10000 = 10000;
        int bill2000 = 2000;
        int bill1000 = 1000;
        int bill500 = 500;
        int bill200 = 200;
        int bill100 = 100;

        if (value > 5000) {
            // Encontrar la combinación de billetes más cercana
            int numBill20000 = (int) value / bill20000;
            double remainder = value % bill20000;

            int numBill10000 = (int) remainder / bill10000;
            remainder = remainder % bill10000;

            int numBill2000 = (int) remainder / bill2000;
            remainder = remainder % bill2000;

            int numBill1000 = (int) remainder / bill1000;
            remainder = remainder % bill1000;

            int numBill500 = (int) remainder / bill500;
            remainder = remainder % bill500;
            if (remainder > 0) {
                numBill500 += 1;
            }

            // Calcular el valor total aproximado
            double roundedValue = numBill20000 * bill20000 + numBill10000 * bill10000 +
                    numBill2000 * bill2000 + numBill1000 * bill1000 +
                    numBill500 * bill500;

            return roundedValue;
        } else {
            int numBill1000 = (int) value / bill1000;
            double remainder = value % bill1000;

            int numBill500 = (int) remainder / bill500;
            remainder = remainder % bill500;

            int numBill200 = (int) remainder / bill200;
            remainder = remainder % bill200;

            int numBill100 = (int) remainder / bill100;
            remainder = remainder % bill100;
            if (remainder > 0) {
                numBill100 += 1;
            }
            double roundedValue = numBill1000 * bill1000 +
                    numBill500 * bill500 + numBill200 * bill200 +
                    numBill100 * bill100;

            return roundedValue;
        }
    }

}