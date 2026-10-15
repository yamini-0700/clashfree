package com.clashfree.service;

import com.clashfree.entity.Teacher;
import com.clashfree.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public Teacher create(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public List<Teacher> getAll() {
        return teacherRepository.findAll();
    }

    public Teacher getById(Long id) {
        return teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found with id " + id));
    }

    public Teacher update(Long id, Teacher updated) {
        Teacher existing = getById(id);
        existing.setName(updated.getName());
        existing.setEmail(updated.getEmail());
        existing.setMaxHoursPerDay(updated.getMaxHoursPerDay());
        return teacherRepository.save(existing);
    }

    public void delete(Long id) {
        getById(id);
        teacherRepository.deleteById(id);
    }
}