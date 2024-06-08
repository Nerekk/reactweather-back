package org.example.reactweatherback.User;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {

    ADMIN_READ("admin:read"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_CREATE("admin:create"),
    ADMIN_DELETE("admin:delete"),

    USER_READ("user:delete"),
    USER_UPDATE("user:delete"),
    USER_CREATE("user:delete"),
    USER_DELETE("user:delete"),
    ;

    @Getter
    private final String permission;
}
