package com.example.demo.controller;

import com.example.demo.model.Journal;
import com.example.demo.dao.JournalJdbc;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;

@RestController
public class JournalController {
    private final JournalJdbc journalJdbc;

    public JournalController(JournalJdbc journalJdbc){
        this.journalJdbc=journalJdbc;
    }

    @GetMapping("/journal/show/id/{id}")
    public Journal getGroup(@PathVariable int id){
        Journal journal = journalJdbc.get(id);
        return journal;
    }
}
