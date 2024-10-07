package net.javaguides.springboot.controller;

import net.javaguides.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    //https://localhost:8080/student/5/Mark/Wood
    //Rest API returns Pathvariable
    @GetMapping("student/{id}/{first-name}/{last-name}")
    public Student getPathVariable(@PathVariable("id") int studentId,
                                   @PathVariable("first-name") String firstName,
                                   @PathVariable("last-name") String lastName) {
        return new Student(studentId, firstName, lastName);
    }


    //https://localhost:8080/student/query?id=5&firstName=Mark&lastName=Wood
    //Rest API returns RequestParam
    @GetMapping("student/query")
    public Student getRequestParam(@RequestParam int id,
                                   @RequestParam String fName,
                                   @RequestParam String lName){
        return new Student(id, fName, lName);
    }


    //handels POST request
    // creating new student
    @PostMapping("student/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){
        System.out.println(student.getAge());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    //handle PUT request
    //updating existing resource
    @PutMapping("student/{id}/update")
    public Student updateStudent(@RequestBody Student student,
                                 @PathVariable("id") int studentId){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }
}
