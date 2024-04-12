package com.sansilvestre.desktop.app.product.util;

public class Settings {

    private static double pertentage = 0.40;

    public static double getPercentage() {
        return pertentage;
    }

    public void setPertentage(double pertentage) {
        this.pertentage = pertentage;
    }

}