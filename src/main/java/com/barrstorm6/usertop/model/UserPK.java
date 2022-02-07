package com.barrstorm6.usertop.model;

import java.io.Serializable;
import java.util.Objects;

public class UserPK implements Serializable {

    private Integer userId;
    private Integer levelId;

    public UserPK() {
    }

    public UserPK(Integer userId, Integer levelId) {
        this.userId = userId;
        this.levelId = levelId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getLevelId() {
        return levelId;
    }

    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPK userid = (UserPK) o;
        return Objects.equals(userId, userid.userId) && Objects.equals(levelId, userid.levelId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, levelId);
    }
}
