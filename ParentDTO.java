package com.sample.test.dto;

import javax.persistence.Column;

public class ParentDTO {

    private   Long  id;

    private   Long  studentId;

    private String firstName;

    private String middleName;

    private String lastName;

    private String email;

    private String type;

    private Long mobileNo;

    public   Long  getId() {
        return id;
    }

    public void setId(  Long  id) {
        this.id = id;
    }

    public   Long  getStudentId() {
        return studentId;
    }

    public void setStudentId(  Long  studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(Long mobileNo) {
        this.mobileNo = mobileNo;
    }
}
