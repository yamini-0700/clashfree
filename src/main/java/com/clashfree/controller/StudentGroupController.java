package com.clashfree.controller;

import com.clashfree.entity.StudentGroup;
import com.clashfree.service.StudentGroupService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/student-groups")
public class StudentGroupController {

    @Autowired
    private StudentGroupService studentGroupService;

    @PostMapping
    public StudentGroup create(@Valid @RequestBody StudentGroup studentGroup) {
        return studentGroupService.create(studentGroup);
    }

    @GetMapping
    public List<StudentGroup> getAll() {
        return studentGroupService.getAll();
    }

    @GetMapping("/{id}")
    public StudentGroup getById(@PathVariable Long id) {
        return studentGroupService.getById(id);
    }

    @PutMapping("/{id}")
    public StudentGroup update(@PathVariable Long id, @Valid @RequestBody StudentGroup studentGroup) {
        return studentGroupService.update(id, studentGroup);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        studentGroupService.delete(id);
    }
}