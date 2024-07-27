package com.sample.test.dto;

import com.sample.test.entity.AddressEntity;
import com.sample.test.entity.ParentEntity;
import com.sample.test.entity.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentSaveDTO {
    StudentEntity studentEntity;

    ParentEntity motherEntity;

    ParentEntity fatherEntity;

    AddressEntity localEntity;

    AddressEntity parmanentEntity;


    public StudentEntity getStudentEntity() {
        return studentEntity;
    }

    public void setStudentEntity(StudentEntity studentEntity) {
        this.studentEntity = studentEntity;
    }

    public ParentEntity getMotherEntity() {
        return motherEntity;
    }

    public void setMotherEntity(ParentEntity motherEntity) {
        this.motherEntity = motherEntity;
    }

    public ParentEntity getFatherEntity() {
        return fatherEntity;
    }

    public void setFatherEntity(ParentEntity fatherEntity) {
        this.fatherEntity = fatherEntity;
    }

    public AddressEntity getLocalEntity() {
        return localEntity;
    }

    public void setLocalEntity(AddressEntity localEntity) {
        this.localEntity = localEntity;
    }

    public AddressEntity getParmanentEntity() {
        return parmanentEntity;
    }

    public void setParmanentEntity(AddressEntity parmanentEntity) {
        this.parmanentEntity = parmanentEntity;
    }
}
