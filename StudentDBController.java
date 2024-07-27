package com.sample.test.controller;


import com.sample.test.entity.StudentDB;
import com.sample.test.service.StudentDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentDBController {

    @Autowired
    StudentDBService studentDBService;

    @GetMapping(value = "/studentList")
    public List<StudentDB>  getAllStudents() {

        List<StudentDB> list = studentDBService.getAllStudent();

        return list;
    }


    @PostMapping(value = "/studentCreate")
    public String createStudent(@RequestBody StudentDB studentdb) {
        System.out.println("Create Student");
        studentDBService.saveStudent(studentdb);
        return "done";
    }



  /*  @GetMapping()
    public StudentDB getStudentsById(Model model,@PathVariable("id") int id) {

            StudentDB studentDB = studentDBService.getStudentbyId(id);

            model.addAttribute("studentbyid",studentDB);
            return studentDB;
        }
*/

}
