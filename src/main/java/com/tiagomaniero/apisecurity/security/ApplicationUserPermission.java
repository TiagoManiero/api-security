package com.tiagomaniero.apisecurity.security;

public enum ApplicationUserPermission {
    ESTUDANTE_READ("estudante:read"),
    ESTUDANTE_WRITE("estudante:write"),
    CURSO_READ("curso:read"),
    CURSO_WRITE("estudante:write");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
