package com.clashfree.service;

import com.clashfree.entity.TimeSlot;
import com.clashfree.repository.TimeSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TimeSlotService {

    @Autowired
    private TimeSlotRepository timeSlotRepository;

    private void checkTimes(TimeSlot timeSlot) {
        if (!timeSlot.getEndTime().isAfter(timeSlot.getStartTime())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "End time must be after start time");
        }
    }

    public TimeSlot create(TimeSlot timeSlot) {
        checkTimes(timeSlot);
        return timeSlotRepository.save(timeSlot);
    }

    public List<TimeSlot> getAll() {
        return timeSlotRepository.findAll();
    }

    public TimeSlot getById(Long id) {
        return timeSlotRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Time slot not found with id " + id));
    }

    public TimeSlot update(Long id, TimeSlot updated) {
        checkTimes(updated);
        TimeSlot existing = getById(id);
        existing.setDayOfWeek(updated.getDayOfWeek());
        existing.setStartTime(updated.getStartTime());
        existing.setEndTime(updated.getEndTime());
        return timeSlotRepository.save(existing);
    }

    public void delete(Long id) {
        getById(id);
        timeSlotRepository.deleteById(id);
    }
}