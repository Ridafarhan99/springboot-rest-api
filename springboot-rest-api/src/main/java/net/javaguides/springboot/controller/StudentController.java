package net.javaguides.springboot.controller;

import net.javaguides.springboot.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    // http://localhost:8080/student
    @GetMapping("student")
    //returns object
    public Student getStudent(){
        Student student = new Student(
                27,
                "Tom",
                "Holland"
        );

        return student;
    }

    @GetMapping("students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(20,"Bruno", "Farnandes"));
        students.add(new Student(23, "Jason", "Roy"));
        students.add(new Student(25, "Mark", "Wood"));
        students.add(new Student(27, "Taylor", "Swift"));
        return students;
    }
}
