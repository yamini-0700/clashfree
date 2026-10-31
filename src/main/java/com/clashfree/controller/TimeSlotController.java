package com.clashfree.controller;

import com.clashfree.entity.TimeSlot;
import com.clashfree.service.TimeSlotService;
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
@RequestMapping("/api/time-slots")
public class TimeSlotController {

    @Autowired
    private TimeSlotService timeSlotService;

    @PostMapping
    public TimeSlot create(@Valid @RequestBody TimeSlot timeSlot) {
        return timeSlotService.create(timeSlot);
    }

    @GetMapping
    public List<TimeSlot> getAll() {
        return timeSlotService.getAll();
    }

    @GetMapping("/{id}")
    public TimeSlot getById(@PathVariable Long id) {
        return timeSlotService.getById(id);
    }

    @PutMapping("/{id}")
    public TimeSlot update(@PathVariable Long id, @Valid @RequestBody TimeSlot timeSlot) {
        return timeSlotService.update(id, timeSlot);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        timeSlotService.delete(id);
    }
}