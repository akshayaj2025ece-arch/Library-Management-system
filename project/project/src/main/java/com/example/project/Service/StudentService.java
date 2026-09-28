package com.example.project.Service;

import com.example.project.Entity.Student;
import com.example.project.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;

    public Student createStudent(Student student) {
        return studentRepo.save(student);
    }

    public List<Student> getStudents() {
        return studentRepo.findAll();
    }

    public Student getStudent(int id) {
        return studentRepo.findById(id).orElse(null);
    }

    public Student updateStudent(Student student) {
        return studentRepo.save(student);
    }

    public String deleteStudent(int id) {
        studentRepo.deleteById(id);
        return "Student deleted successfully";
    }
}