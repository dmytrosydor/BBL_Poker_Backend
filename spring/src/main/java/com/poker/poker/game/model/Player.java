package com.poker.poker.game.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Player {
    private UUID id;
    private String nickname;
    private int avatar;

    public Player(String nickname, int avatar) {
        this.id = UUID.randomUUID();
        this.nickname = nickname;
        this.avatar = avatar;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAvatar() {
        return avatar;
    }
}
