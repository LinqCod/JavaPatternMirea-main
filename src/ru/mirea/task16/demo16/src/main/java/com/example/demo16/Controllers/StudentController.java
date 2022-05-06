package com.example.demo16.Controllers;

import com.example.demo16.services.TableService;
import com.example.demo16.tables.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private final TableService<Student> serviceTableService;

    @Autowired
    public StudentController(TableService<Student> serviceTableService) {
        this.serviceTableService = serviceTableService;
    }

    /**
     * ResponseEntity — специальный класс для возврата ответов.
     * С помощью него мы сможем в дальнейшем вернуть клиенту HTTP статус код. */
    @PostMapping(value = "/students",consumes = {"application/json"})
    public ResponseEntity<?> createStudent(@RequestBody Student student) {
        serviceTableService.createEntity(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value="/students")
    public ResponseEntity<List<Student>> read() {
        final List<Student> students = serviceTableService.readAllEntity();
        return students != null && !students.isEmpty()
                ? new ResponseEntity<>(students, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value="/students/{id}")
    public ResponseEntity<Student> read(@PathVariable(name="id") long id) {
        System.out.println("\nqwe");
        final Student student = serviceTableService.readOneEntity(id);
        return student != null
                ? new ResponseEntity<>(student, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value="/students/{id}")
    public ResponseEntity<?> update(@PathVariable(name="id") long id, @RequestBody Student student) {
        final boolean isUpdated = serviceTableService.updateEntity(student, id);
        return isUpdated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value="/students/{id}")
    public ResponseEntity<?> delete(@PathVariable(name="id") long id) {
        final boolean isDeleted = serviceTableService.deleteEntity(id);
        return isDeleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}
