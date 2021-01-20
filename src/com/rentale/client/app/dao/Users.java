package com.rentale.client.app.dao;

public class Users {

    private int id;
    private String email;
    private String password;
    private char role;

    public Users(int id, String email, String password, char role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public char getRole() {
        return role;
    }
}
