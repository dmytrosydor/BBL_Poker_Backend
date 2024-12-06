package com.poker.poker.dto;

public class UserResponse {
    private String uuid;

    public UserResponse(String uuid) {
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }
}
