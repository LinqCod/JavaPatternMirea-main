package com.example.demo14.Controllers;

import com.example.demo14.Entity.Groups;
import com.example.demo14.Entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ControllerGroup {
    private ArrayList<Groups> list2 = new ArrayList<>();


    @PostMapping(value = "/add-group")
    @ResponseBody
    public String createGroup(@RequestParam("groupname") String name) {
        System.out.println(name);
        Groups group = new Groups(name);
        list2.add(group);
        return group.toString();
    }

    @GetMapping(value = "/show-groups")
    @ResponseBody
    public Object[] showGroups() {
        return list2.stream()
                .filter(item -> item instanceof Groups).toArray();
    }

    @GetMapping(value = "/delete-group")
    @ResponseBody
    public boolean deleteGroup(@RequestParam("groupname") String name) {
        int temp = list2.size();
        list2.removeIf(i -> i.getGroupName().equals(name));
        return temp != list2.size() ?  true :  false;
    }
}
