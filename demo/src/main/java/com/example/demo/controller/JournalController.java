package com.example.demo.controller;

import com.example.demo.model.Journal;
import com.example.demo.dao.JournalJdbc;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("/journal/show/all")
    public List<Journal> getAllJournal(){
        List<Journal> journals = journalJdbc.getAll();
        return journals;
    }

    @GetMapping("/journal/show/student/{studid}")
    public List<Journal> getAllJournalOnStudent(@PathVariable int studid){
        List<Journal> journals = journalJdbc.getAllOnStudent(studid);
        return journals;
    }

    @GetMapping("/journal/show/group/{groupid}")
    public List<Journal> getAllJournalOnGroup(@PathVariable int groupid){
        List<Journal> journals = journalJdbc.getAllOnGroup(groupid);
        return journals;
    }

    @GetMapping("/journal/update/{id}/{value}")
    public String updateJournal(@PathVariable int id, @PathVariable int value){
        journalJdbc.updateJournal(id,value);
        return "Выполнено";
    }
}
