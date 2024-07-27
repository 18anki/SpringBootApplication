package com.sample.test.dto;

public class AddressDTO {

    private  Long  id;

    private  Long  studentId;

    private String address;

    private String state;

    private String city;

    private String type;

    private  Integer pincode;

    public  Long  getId() {
        return id;
    }

    public void setId(  Long  id) {
        this.id = id;
    }

    public  Long  getStudentId() {
        return studentId;
    }

    public void setStudentId(  Long  studentId) {
        this.studentId = studentId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public  Integer getPincode() {
        return pincode;
    }

    public void setPincode( Integer  pincode) {
        this.pincode = pincode;
    }
}
