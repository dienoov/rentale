package com.rentale.client.app.dao;

public class Venue {

    private String name;
    private String location;
    private String desc;

    public Venue() {
        this.name = "";
        this.location = "";
        this.desc = "";
    }

    public Venue(String name, String location, String desc) {
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
