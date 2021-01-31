package com.rentale.client.app.dao;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Venues {

    private SimpleIntegerProperty id;
    private SimpleStringProperty name;
    private SimpleStringProperty location;
    private SimpleStringProperty address;
    private SimpleStringProperty desc;

    public Venues(int id, String name, String location, String address, String desc) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.location = new SimpleStringProperty(location);
        this.address = new SimpleStringProperty(address);
        this.desc = new SimpleStringProperty(desc);
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

    public String getLocation() {
        return location.get();
    }

    public SimpleStringProperty locationProperty() {
        return location;
    }

    public void setLocation(String location) {
        this.location.set(location);
    }

    public String getAddress() {
        return address.get();
    }

    public SimpleStringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public String getDesc() {
        return desc.get();
    }

    public SimpleStringProperty descProperty() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc.set(desc);
    }
}
