package com.cibertec.uberclone.models;

public class Driver {

    String id;
    String name;
    String email;
    String vehicleBrand;
    String vehiclePate;

    public Driver(String id, String name, String email, String vehicleBrand, String vehiclePate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.vehicleBrand = vehicleBrand;
        this.vehiclePate = vehiclePate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVehicleBrand() {
        return vehicleBrand;
    }

    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }

    public String getVehiclePate() {
        return vehiclePate;
    }

    public void setVehiclePate(String vehiclePate) {
        this.vehiclePate = vehiclePate;
    }
}
