package org.jpa.jpacollection.controller;


import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.extern.slf4j.Slf4j;
import org.jpa.jpacollection.entity.Student;
import org.jpa.jpacollection.repository.MainEm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@Slf4j
public class StudentController {
    @Autowired
    MainEm mainEm;


    @GetMapping("/all")
    public List<Student> listAll(){
        return mainEm.findAll();
    }

    @PostConstruct
    public void init(){
        Student student = new Student("길동", "홍","hong1@gmail.com");
        List<String> courses = student.getCourses();

        courses.add("수학");
        courses.add("국어");
        courses.add("영어");

        mainEm.insert(student);
    }

    @PostMapping("/newStudent")
    public void newStudent(@RequestBody Student student){
        log.info("------------->학생정보: {}", student);
        Long sid = mainEm.insert(student);
        log.info("------------->학생입력!!");
    }

    @GetMapping("/newCourse/{id}/{course}")
    public void newCourse(@PathVariable Long id, @PathVariable String course){
        log.info("------------->학생id : {}, 과목명 :{}", id, course);
        mainEm.insertNewCourse(id, course);
        log.info("------------->과목 입력!!");
    }
}
