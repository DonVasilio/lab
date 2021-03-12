package com.example.demo.controller;

import com.example.demo.model.Journal;
import com.example.demo.dao.JournalJdbc;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
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

    @PostMapping("/journal/update")
    public String updateJournal(@RequestBody Journal journal){
        journalJdbc.updateJournal(journal.getId(),journal.getMark_id());
        return "Выполнено";
    }

    @GetMapping("/journal/whole")
    public List<?> getWhole()
    {
        List<?> whole = journalJdbc.getWhole();
        return whole;
    }
}
