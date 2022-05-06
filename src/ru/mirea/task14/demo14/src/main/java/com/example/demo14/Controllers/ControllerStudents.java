package com.example.demo14.Controllers;

import com.example.demo14.Entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ControllerStudents {
    private ArrayList<Student> list = new ArrayList<>();

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getTestPage() {
        return "home.html";
    }

    @PostMapping(value = "/add-student")
    @ResponseBody
    public String createStudent(@RequestParam("name") String name,@RequestParam("surname") String surname, @RequestParam("midlename")String midlename) {
        System.out.println(name +" " + surname+" "+midlename);
        Student student = new Student(name, surname, midlename);
        System.out.println(student.getFirstName());
        list.add(student);
        System.out.println(student);
        return student.toString();
    }

    @GetMapping(value = "/show-student")
    @ResponseBody
    public Object[] showStudents() {
        return list.stream()
                .filter(item -> item instanceof Student).toArray();
    }

    @GetMapping(value = "/delete-student")
    @ResponseBody
    public boolean deleteStudent(@RequestParam("name") String name,@RequestParam("surname") String surname, @RequestParam("midlename")String midlename) {
        List<Student> rList = new ArrayList<>();
        list.stream()
                .filter(item -> item instanceof Student)
                .map(Student.class::cast)
                .filter(student -> student.getFirstName().equals(name) &&
                        student.getLastName().equals(surname) &&
                        student.getMiddleName().equals(midlename))
                .forEach(rList::add);
        list.removeAll(rList);
        return rList.size() != 0 ?  true :  false;
    }
}
