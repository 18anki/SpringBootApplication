package com.sample.test.service;

import com.sample.test.Repository.StudentDBRepository;
import com.sample.test.entity.StudentDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentDBService implements StudentDBServiceInter{

    @Autowired
    StudentDBRepository studentDBRepositoryitory;

    @Override
    public List<StudentDB> getAllStudent() {
       List<StudentDB> studentList= (List<StudentDB>) studentDBRepositoryitory.findAll();
       return studentList;
    }


    public StudentDB saveStudent(StudentDB studentdb){

        System.out.println("save Student");

       studentdb=studentDBRepositoryitory.save(studentdb);
       return studentdb;

    }

    public  StudentDB getStudentbyId(int id){
        Optional<StudentDB> studentId =studentDBRepositoryitory.findById(id);
        return studentId.get();

    }
}
