package com.clashfree.controller;

import com.clashfree.entity.Subject;
import com.clashfree.service.SubjectService;
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
@RequestMapping("/api/subjects")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping
    public Subject create(@Valid @RequestBody Subject subject) {
        return subjectService.create(subject);
    }

    @GetMapping
    public List<Subject> getAll() {
        return subjectService.getAll();
    }

    @GetMapping("/{id}")
    public Subject getById(@PathVariable Long id) {
        return subjectService.getById(id);
    }

    @PutMapping("/{id}")
    public Subject update(@PathVariable Long id, @Valid @RequestBody Subject subject) {
        return subjectService.update(id, subject);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        subjectService.delete(id);
    }
}