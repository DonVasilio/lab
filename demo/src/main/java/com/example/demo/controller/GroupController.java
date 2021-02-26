package com.example.demo.controller;

import com.example.demo.dao.GroupJdbc;
import com.example.demo.model.Group;
import com.example.demo.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GroupController {
    private final GroupJdbc groupJdbc;

    public GroupController(GroupJdbc groupJdbc){
        this.groupJdbc=groupJdbc;
    }

    @GetMapping("/group/show/id/{id}")
    public Group getGroup(@PathVariable int id){
        Group group = groupJdbc.get(id);
        return group;
    }

    @GetMapping("/group/show/all")
    public List<Group> getAllGroup(){
        List<Group> groups = groupJdbc.getAll();
        return groups;
    }

    @GetMapping("/group/insert/{id}/{name}")
    public String createGroup(@PathVariable int id,@PathVariable String name){
        groupJdbc.createGroup(id, name);
        return "Выполнено";
    }

    @GetMapping("/group/delete/{id}")
    public String deleteGroup(@PathVariable int id){
        groupJdbc.deleteGroup(id);
        return "Выполнено";
    }

    @GetMapping("/group/update/{id}/{value}")
    public String updateGroup(@PathVariable int id, @PathVariable String value){
        groupJdbc.updateGroup(id, value);
        return "Выполнено";
    }
}
