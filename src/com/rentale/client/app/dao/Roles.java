package com.rentale.client.app.dao;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Roles {

    private SimpleIntegerProperty id;
    private SimpleStringProperty name;

    public Roles(int id, String name) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
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

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    @Override
    public String toString() {
        return this.getName();
    }

    public static ObservableList<Roles> getAllRoles() {
        ObservableList<Roles> roles = FXCollections.observableArrayList();
        roles.add(new Roles(1, "Admin"));
        roles.add(new Roles(2, "Staff"));
        return roles;
    }
}
