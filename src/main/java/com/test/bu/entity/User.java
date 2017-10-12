package com.test.bu.entity;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    private String username;
    private String password;
    @Enumerated(EnumType.ORDINAL)
    private Role role;
    private enum Role {USER, ADMIN;}


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
