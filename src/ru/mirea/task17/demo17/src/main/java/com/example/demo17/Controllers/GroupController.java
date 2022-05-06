package com.example.demo17.Controllers;


import com.example.demo17.services.GroupService;
import com.example.demo17.services.TableService;
import com.example.demo17.tables.Groups;
import com.example.demo17.tables.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GroupController {
    private final GroupService serviceTableService;

    @Autowired
    public GroupController(GroupService serviceTableService) {
        this.serviceTableService = serviceTableService;
    }

    /**
     * ResponseEntity — специальный класс для возврата ответов.
     * С помощью него мы сможем в дальнейшем вернуть клиенту HTTP статус код. */
    @PostMapping(value = "/groups",consumes = {"application/json"})
    public ResponseEntity<?> createStudent(@RequestBody Groups student) {
        serviceTableService.createEntity(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value="/groups")
    public ResponseEntity<List<Groups>> read() {
        final List<Groups> students = serviceTableService.readAllEntity();
        return students != null && !students.isEmpty()
                ? new ResponseEntity<>(students, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value="/groups/{id}")
    public ResponseEntity<Groups> read(@PathVariable(name="id") long id) {
        System.out.println("\nqwe");
        final Groups student = serviceTableService.readOneEntity(id);
        return student != null
                ? new ResponseEntity<>(student, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value="/groups/{id}")
    public ResponseEntity<?> update(@PathVariable(name="id") long id, @RequestBody Groups student) {
        final boolean isUpdated = serviceTableService.updateEntity(student, id);
        return isUpdated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value="/groups/{id}")
    public ResponseEntity<?> delete(@PathVariable(name="id") long id) {
        final boolean isDeleted = serviceTableService.deleteEntity(id);
        return isDeleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping(value = "/show-groups-orderBy-name")
    public ResponseEntity<List<Groups>> showAuthorsOrderByDate() {
        final List<Groups> students = serviceTableService.sortGroupsByName();
        return students != null && !students.isEmpty()
                ? new ResponseEntity<>(students, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value="/groups/name/{firstName}")
    public ResponseEntity<List<Groups>> getPhonesByYear(@PathVariable(name="firstName") String firstName) {
        final List<Groups> groups = serviceTableService.filterStudentByFirstName(firstName);
        return groups != null && !groups.isEmpty()
                ? new ResponseEntity<>(groups, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
