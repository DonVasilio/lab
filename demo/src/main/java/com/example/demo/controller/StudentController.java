package com.example.demo.controller;

import com.example.demo.dao.StudentJdbc;
import com.example.demo.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class StudentController {
    private final StudentJdbc studentJdbc;

    public StudentController(StudentJdbc studentJdbc){
        this.studentJdbc=studentJdbc;
    }

    @GetMapping("/student/show/id/{id}")
    public Student getStudent(@PathVariable int id){
        Student student = studentJdbc.get(id);
        return student;
    }

    @GetMapping("/student/show/all")
    public List<Student> getAllStudent(){
        List<Student> students = studentJdbc.getAll();
        return students;
    }

    @GetMapping("/student/show/group/{group}")
    public List<Student> getAllStudent(@PathVariable int group){
        List<Student> students = studentJdbc.getAllOnGroup(group);
        return students;
    }

    @PostMapping("/student/insert")
    public String createStudent(@RequestBody Student student){
        studentJdbc.createStudent(student.getId(), student.getSurname(), student.getName(), student.getSecond_name(), student.getStudy_group_id());
        return "Выполнено";
    }

    @GetMapping("/student/delete/{id}")
    public String deleteStudent(@PathVariable int id){
        studentJdbc.deleteStudent(id);
        return "Выполнено";
    }

    @PostMapping("/student/update")
    public String updateStudent(@RequestBody Student student){
        studentJdbc.updateStudent(student);
        return "Выполнено";
    }
}
