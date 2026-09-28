package com.example.project.Controller;

import com.example.project.Entity.Student;
import com.example.project.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/createStudent")
    public ResponseEntity<?> createStudent(
            @RequestBody Student student) {

        return new ResponseEntity<>(
                studentService.createStudent(student),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/getStudents")
    public ResponseEntity<?> getStudents() {

        return new ResponseEntity<>(
                studentService.getStudents(),
                HttpStatus.OK
        );
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<?> getStudent(
            @PathVariable int id) {

        return new ResponseEntity<>(
                studentService.getStudent(id),
                HttpStatus.OK
        );
    }

    @PutMapping("/updateStudent")
    public ResponseEntity<?> updateStudent(
            @RequestBody Student student) {

        return new ResponseEntity<>(
                studentService.updateStudent(student),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<?> deleteStudent(
            @PathVariable int id) {

        return new ResponseEntity<>(
                studentService.deleteStudent(id),
                HttpStatus.OK
        );
    }
}