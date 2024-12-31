package com.api.parking_control.models;

public enum UserRole { //Criando as role da API EX: esse vai ter administrador e usuário
    ADMIN("admin"),
    USER("user");

    private final String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
