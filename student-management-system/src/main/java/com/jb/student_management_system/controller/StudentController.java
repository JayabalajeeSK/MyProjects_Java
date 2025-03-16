package com.jb.student_management_system.controller;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.jb.student_management_system.dto.StudentDto;
import com.jb.student_management_system.service.StudentService;

import jakarta.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Controller//become mvc controller - capable to handle Rest API
@RequestMapping
public class StudentController 
{
    private StudentService studentService; // using interface

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //handle - List of all students
    @GetMapping("/students")
    public String listStudents(Model model)
    {
        List<StudentDto> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "students";
    }

    //handle - Add new student
    @GetMapping("/students/new")
    public String newStudent(Model model)
    {
        StudentDto studentDto = new StudentDto();
        model.addAttribute("student", studentDto);
        return "create_student";
    }

    //handle - save student form submit request
    @PostMapping("/students")
    public String saveStudent(@Valid @ModelAttribute("student") StudentDto student, BindingResult result, Model model)// all changes will save in the model attribute - student class
    {
        if(result.hasErrors())
        {
            model.addAttribute("student", student);
            return "create_student";
        }
        studentService.createStudent(student);
        return "redirect:/students"; // save and redirect to the students page to list all students
    }
}
