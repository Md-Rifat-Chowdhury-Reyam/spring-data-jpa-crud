package com.example.controller;

import com.example.model.Student;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/student")
public class StudentController {


    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;

    }

    @GetMapping("/all")
    public List<Student> getAll()
    {
        return studentService.getAllStudents();
    }

    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student)
    {
        return studentService.saveStudent(student);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id)
    {
        return studentService.findById(id).map(ResponseEntity:: ok).orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable int id)
    {
       studentService.deleteStudentById(id);
    }
}
