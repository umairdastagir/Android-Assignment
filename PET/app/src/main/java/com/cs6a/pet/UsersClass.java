package com.cs6a.pet;

public class UsersClass {

int Id;
String name;
String password;

public UsersClass(){}

    public UsersClass(int id, String name, String password) {
        Id = id;
        this.name = name;
        this.password = password;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPassword(String password){
    this.password = password;
    }
    public String getPassword(){
    return password;
    }
}
