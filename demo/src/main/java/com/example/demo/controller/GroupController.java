package com.example.demo.controller;

import com.example.demo.dao.GroupJdbc;
import com.example.demo.model.Group;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
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
        List<Group> groups = groupJdbc.getAllGroup();
        return groups;
    }

    @PostMapping("/group/insert")
    public String createGroup(@RequestBody Group group){
        groupJdbc.createGroup(group.getId(), group.getName());
        return "Выполнено";
    }

    @GetMapping("/group/delete/{id}")
    public String deleteGroup(@PathVariable int id){
        groupJdbc.deleteGroup(id);
        return "Выполнено";
    }

    @PostMapping("/group/update")
    public String updateGroup(@RequestBody Group group){
        groupJdbc.updateGroup(group.getId(), group.getName());
        return "Выполнено";
    }
}
