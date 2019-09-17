package com.scoliztur.game.mafia.filters.model;

import lombok.Getter;

@Getter
public enum RoleStatus {

    PLAYER("PLAYER_USER_ROLE"),
    LEADING("LEADING_USER_ROLE");

    private String userRole;

    RoleStatus(String userRole) {
        this.userRole = userRole;
    }
}
