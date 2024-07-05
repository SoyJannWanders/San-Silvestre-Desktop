package com.sansilvestre.desktop.app.user.domain.model;

import java.util.Arrays;
import java.util.List;

public enum Role {

    DEFAULT("General"),
    EMPLOYEE("Empleado"),
    MODERATOR("Moderador"),
    MANAGER("Gerente"),
    ADMINISTRATOR("Administrador");

    private final String name;

    Role(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public static List<Role> getRoles() {
        return Arrays.asList(Role.values());
    }

}