package net.javaguides.springboot.controller;

import net.javaguides.springboot.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    //Rest API returns LIST
    @GetMapping("students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(20,"Bruno", "Farnandes"));
        students.add(new Student(23, "Jason", "Roy"));
        students.add(new Student(25, "Mark", "Wood"));
        students.add(new Student(27, "Taylor", "Swift"));
        return students;
    }

    //Rest API returns Pathvariable
    @GetMapping("student/{id}/{first-name}/{last-name}")
    public Student getPathVariable(@PathVariable("id") int studentId,
                                   @PathVariable("first-name") String firstName,
                                   @PathVariable("last-name") String lastName) {
        return new Student(studentId, firstName, lastName);
    }
}
