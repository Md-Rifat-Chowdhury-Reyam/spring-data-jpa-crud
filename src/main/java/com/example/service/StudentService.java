package com.example.service;

import com.example.dao.StudentRepository;
import com.example.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Transactional
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Transactional(readOnly = true)
    public List<Student> getAllStudents() {

        List<Student> allStudent = new ArrayList<>(studentRepository.findAll());
        return allStudent;
    }

    @Transactional
    public Student findById(int id)
    {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found with " + id));
    }

    @Transactional
    public void deleteStudentById(int id)
    {
        studentRepository.deleteById(id);
    }
}
