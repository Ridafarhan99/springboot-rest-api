package net.javaguides.springboot.controller;

import net.javaguides.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    // http://localhost:8080/student
    @GetMapping()
    //returns object
    public ResponseEntity<Student> getStudent(){
        Student student = new Student(
                27,
                "Tom",
                "Holland"
        );

        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    //Rest API returns LIST
    @GetMapping()
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(20,"Bruno", "Farnandes"));
        students.add(new Student(23, "Jason", "Roy"));
        students.add(new Student(25, "Mark", "Wood"));
        students.add(new Student(27, "Taylor", "Swift"));
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    //https://localhost:8080/student/5/Mark/Wood
    //Rest API returns Pathvariable
    @GetMapping("{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> getPathVariable(@PathVariable("id") int studentId,
                                   @PathVariable("first-name") String firstName,
                                   @PathVariable("last-name") String lastName) {
        Student student = new Student(studentId, firstName, lastName);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }


    //https://localhost:8080/student/query?id=5&firstName=Mark&lastName=Wood
    //Rest API returns RequestParam
    @GetMapping("query")
    public ResponseEntity<Student> getRequestParam(@RequestParam int id,
                                   @RequestParam String fName,
                                   @RequestParam String lName){
        Student student = new Student(id, fName, lName);
        return ResponseEntity.ok(student);
    }


    //handels POST request
    // creating new student
    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        System.out.println(student.getAge());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    //handle PUT request
    //updating existing resource
    @PutMapping("{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student,
                                 @PathVariable("id") int studentId){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<>(student, HttpStatus.OK);
    }


    //handle DELETE request
    //delete existing resource
    @DeleteMapping("{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId){
        System.out.println(studentId);
        String msg = "Deleted Successfully";
        return ResponseEntity.ok(msg);
    }
}
