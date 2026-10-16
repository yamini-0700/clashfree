package com.clashfree.service;

import com.clashfree.entity.Subject;
import com.clashfree.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public Subject create(Subject subject) {
        return subjectRepository.save(subject);
    }

    public List<Subject> getAll() {
        return subjectRepository.findAll();
    }

    public Subject getById(Long id) {
        return subjectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subject not found with id " + id));
    }

    public Subject update(Long id, Subject updated) {
        Subject existing = getById(id);
        existing.setName(updated.getName());
        existing.setCode(updated.getCode());
        return subjectRepository.save(existing);
    }

    public void delete(Long id) {
        getById(id);
        subjectRepository.deleteById(id);
    }
}