package com.jb.spring_security_demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jb.spring_security_demo.model.Student;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class StudentController {
    List<Student> students = new ArrayList<>(List.of(
        new Student(1,"jaya", "java" ),
        new Student(2,"bala", "python" ),
        new Student(3,"jayabala", "data analyst" )
    ));

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request)
    {
        return (CsrfToken) request.getAttribute("_csrf");

    }

    @GetMapping("/students")
    public List<Student> getStudents()
    {
        return students;
    }
    @PostMapping("/students")
    public void addStudents(@RequestBody Student student)
    {
        students.add(student);
    }
}