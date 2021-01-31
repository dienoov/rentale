package com.rentale.client.app.dao;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Users {

    private SimpleIntegerProperty id;
    private SimpleStringProperty email;
    private SimpleIntegerProperty role;
    private String roleName;

    public Users(int id, String email, int role) {
        this.id = new SimpleIntegerProperty(id);
        this.email = new SimpleStringProperty(email);
        this.role = new SimpleIntegerProperty(role);
        this.roleName = role == 1 ? "Admin" : "Staff";
    }

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public int getRole() {
        return role.get();
    }

    public SimpleIntegerProperty roleProperty() {
        return role;
    }

    public void setRole(int role) {
        this.role.set(role);
    }

    public String getRoleName() {
        return roleName;
    }
}
