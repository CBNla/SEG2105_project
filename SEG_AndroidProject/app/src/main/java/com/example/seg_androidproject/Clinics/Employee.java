package com.example.seg_androidproject.Clinics;

public class Employee {
    private String userName;
    private String password;
    private String name;
    private String address;
    private int phoneNum;
    private String nameOfClinic;
    private String insuranceTypes;
    private String paymentMethod;
    private String workingHours;

    public Employee(){}

    public Employee(String userName, String password, String name){
        this.userName = userName;
        this.name = name;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getAddress(){
        return address;
    }

    public void setPhoneNum(int phoneNum){
        this.phoneNum = phoneNum;
    }

    public int getPhoneNum(){
        return phoneNum;
    }

    public void setNameOfClinic(String nameOfClinic){
        this.nameOfClinic = nameOfClinic;
    }

    public String getNameOfClinic(){
        return nameOfClinic;
    }

    public void setInsuranceTypes(String insuranceTypes){
        this.insuranceTypes = insuranceTypes;
    }

    public String getInsuranceTypes(){
        return insuranceTypes;
    }

    public void setPaymentMethod(String paymentMethod){
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentMethod(){
        return paymentMethod;
    }

    public void setWorkingHours(String workingHours){
        this.workingHours = workingHours;
    }

    public String getWorkingHours(){
        return workingHours;
    }
}
