package com.sample.test.dto;


public class StudentCreateDTO {

    StudentDTO studentinfo;

    ParentDTO fatherinfo;

    ParentDTO motherinfo;

    AddressDTO localAddress;

    AddressDTO permanentAddress;

    ParentDTO parentinfo;

    AddressDTO addressinfo;

    public StudentDTO getStudentinfo() {
        return studentinfo;
    }

    public void setStudentinfo(StudentDTO studentinfo) {
        this.studentinfo = studentinfo;
    }

    public ParentDTO getFatherinfo() {
        return fatherinfo;
    }

    public void setFatherinfo(ParentDTO fatherinfo) {
        this.fatherinfo = fatherinfo;
    }

    public ParentDTO getMotherinfo() {
        return motherinfo;
    }

    public void setMotherinfo(ParentDTO motherinfo) {
        this.motherinfo = motherinfo;
    }

    public AddressDTO getLocalAddress() {
        return localAddress;
    }

    public void setLocalAddress(AddressDTO localAddress) {
        this.localAddress = localAddress;
    }

    public AddressDTO getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(AddressDTO permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public ParentDTO getParentinfo() {
        return parentinfo;
    }

    public void setParentinfo(ParentDTO parentinfo) {
        this.parentinfo = parentinfo;
    }

    public AddressDTO getAddressinfo() {
        return addressinfo;
    }

    public void setAddressinfo(AddressDTO addressinfo) {
        this.addressinfo = addressinfo;
    }
}
