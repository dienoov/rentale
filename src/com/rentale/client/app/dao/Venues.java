package com.rentale.client.app.dao;

public class Venues {

    private String name;
    private String location;
    private String desc;

    public Venues() {
        this.name = "";
        this.location = "";
        this.desc = "";
    }

    public Venues(String name, String location, String desc) {
        this.name = name;
        this.location = location;
        this.desc = desc;
    }

    public String getName(){
        return name;
    }

    public String getLocation(){
        return location;
    }

    public String getDesc(){
        return desc;
    }

}
