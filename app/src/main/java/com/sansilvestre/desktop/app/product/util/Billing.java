package com.sansilvestre.desktop.app.product.util;

import com.sansilvestre.desktop.app.util.formatter.Currency;
import com.sansilvestre.desktop.app.util.formatter.Rounder;

public class Billing {

    private String input;
    private double cost = 0;

    public void build(double cost) {

    }

    public void build(String input) {
        String rawInput = Currency.removeFormat(input);
        if (rawInput.isEmpty()) {
            this.input = rawInput;
            this.cost = 0;
        } else {
            if (rawInput.charAt(rawInput.length() - 1) != ',') {
                rawInput = rawInput.replace(Currency.DECIMAL_SEPARATOR, Currency.GROUPING_SEPARATOR);
                this.input = Currency.format(Double.parseDouble(rawInput));
                this.cost = Double.parseDouble(rawInput);
            } else {
                this.input = input;
            }
        }
    }

    public String getInput() {
        return input;
    }

    public String getFormattedCost() {
        return input.isEmpty() ? "$ 0,00" : Currency.format(getCost());
    }

    public void setCost(double cost) {
        this.cost = cost;
        input = Currency.format(cost);
    }

    public double getCost() {
        return cost;
    }

    public String getFormattedProfit() {
        return input.isEmpty() ? "$ 0,00" : Currency.format(getProfit());
    }

    public double getProfit() {
        return (cost /(1 - 40)) - cost;
    }

    public String getFormattedPrice() {
        return input.isEmpty() ? "$ 0,00" : Currency.format(getPrice());
    }

    public double getPrice() {
        return cost + getProfit();
    }

    public String getFormattedRoundedPrice() {
        return input.isEmpty() ? "$ 0,00" : Currency.format(calculateRoundedPrice());
    }

    public double calculateRoundedPrice() {
        return Rounder.round(getPrice());
    }

}