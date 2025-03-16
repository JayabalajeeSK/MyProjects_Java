package com.jb.student_management_system.controller;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.jb.student_management_system.dto.StudentDto;
import com.jb.student_management_system.service.StudentService;
import org.springframework.ui.Model;

@Controller//become mvc controller - capable to handle Rest API
@RequestMapping
public class StudentController 
{
    private StudentService studentService; // using interface

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("/student")
    public String listStudents(Model model)
    {
        List<StudentDto> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "students";

    }
}
