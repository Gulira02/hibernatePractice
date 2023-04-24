package org.example.dao;

import org.example.entity.Student;

import java.util.List;

public interface StudentDao {
    String saveStudent(Student student);
    Student getStudentById(Long id);
    Student updateStudentById(Long id,Student student);
    List<Student> getAllStudents();
    String deleteStudentById(Long id);

}
