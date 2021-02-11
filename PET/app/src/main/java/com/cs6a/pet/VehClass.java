package com.cs6a.pet;

public class VehClass {

    int Id;
    String made;
    String reg;
    String model;

    public VehClass(){}

    public VehClass(int id, String made, String reg, String model) {
        Id = id;
        this.made = made;
        this.reg = reg;
        this.model = model;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getMade() {
        return made;
    }

    public void setMade(String made) {
        this.made = made;
    }

    public String getReg() {
        return reg;
    }

    public void setReg(String reg) {
        this.reg = reg;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
