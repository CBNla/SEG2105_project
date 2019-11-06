package com.example.seg_androidproject.Clinics;

public class Clients {
    private String name;
    private int age;
    private String userName;
    private String password;

    public Clients(){}

    public Clients(String userName, String password, String name, int age){
        this.name = name;
        this.age = age;
        this.userName = userName;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
