package com.sansilvestre.desktop.app.product.create.domain.util;

public class Utilities {

    private static double profitPercentage = 0.4;

    public static void add(double percentage) {
        profitPercentage = profitPercentage + percentage;
    }

    public static void remove(double percentage) {
        profitPercentage = profitPercentage - percentage;
    }

    public static double getProfitPercentage() {
        return profitPercentage;
    }

    public void setProfitPercentage(double profitPercentage) {
        this.profitPercentage = profitPercentage;
    }

}