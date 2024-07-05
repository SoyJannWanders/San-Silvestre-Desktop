package com.sansilvestre.desktop.app.client.domain.model;

import java.time.LocalDateTime;

public class Client {

    private int id;
    private String name;
    private String surname;
    private String document;
    private double discount;
    private LocalDateTime addedDate;
    private LocalDateTime updatedDate;

    public Client(String name, String surname, String document, double discount) {
        id = 1;
        this.name = name;
        this.surname = surname;
        this.document = document;
        this.discount = discount;
    }

    @Override
    public String toString() {
        return name;
    }
}