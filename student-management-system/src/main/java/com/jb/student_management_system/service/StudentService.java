package com.jb.student_management_system.service;
import java.util.List;
import com.jb.student_management_system.dto.StudentDto;
public interface StudentService 
{
    List<StudentDto> getAllStudents();

    void createStudent(StudentDto student);

    StudentDto getStudentById(Long studentId);

}
