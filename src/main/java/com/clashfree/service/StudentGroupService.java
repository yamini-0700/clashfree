package com.clashfree.service;

import com.clashfree.entity.StudentGroup;
import com.clashfree.repository.StudentGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentGroupService {

    @Autowired
    private StudentGroupRepository studentGroupRepository;

    public StudentGroup create(StudentGroup studentGroup) {
        return studentGroupRepository.save(studentGroup);
    }

    public List<StudentGroup> getAll() {
        return studentGroupRepository.findAll();
    }

    public StudentGroup getById(Long id) {
        return studentGroupRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student group not found with id " + id));
    }

    public StudentGroup update(Long id, StudentGroup updated) {
        StudentGroup existing = getById(id);
        existing.setName(updated.getName());
        existing.setSize(updated.getSize());
        return studentGroupRepository.save(existing);
    }

    public void delete(Long id) {
        getById(id);
        studentGroupRepository.deleteById(id);
    }
}