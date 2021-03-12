package com.example.demo.controller;

import com.example.demo.dao.SubjectTypeJdbc;
import com.example.demo.model.SubjectType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class SubjectTypeController {
    private final SubjectTypeJdbc subjectTypeJdbc;

    public SubjectTypeController(SubjectTypeJdbc subjectTypeJdbc){
        this.subjectTypeJdbc=subjectTypeJdbc;
    }

    @GetMapping("/subject/type/show")
    public List<SubjectType> get(){
        List<SubjectType> subjectTypes = subjectTypeJdbc.get();
        return subjectTypes;
    }
}