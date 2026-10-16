package com.clashfree.service;

import com.clashfree.entity.Room;
import com.clashfree.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public Room create(Room room) {
        return roomRepository.save(room);
    }

    public List<Room> getAll() {
        return roomRepository.findAll();
    }

    public Room getById(Long id) {
        return roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found with id " + id));
    }

    public Room update(Long id, Room updated) {
        Room existing = getById(id);
        existing.setName(updated.getName());
        existing.setCapacity(updated.getCapacity());
        return roomRepository.save(existing);
    }

    public void delete(Long id) {
        getById(id);
        roomRepository.deleteById(id);
    }
}