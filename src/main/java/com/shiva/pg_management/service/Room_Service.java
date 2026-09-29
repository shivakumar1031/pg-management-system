package com.shiva.pg_management.service;

import com.shiva.pg_management.entity.PG;
import com.shiva.pg_management.entity.Room;
import com.shiva.pg_management.repository.PG_Repository;
import com.shiva.pg_management.repository.Room_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Room_Service {

    @Autowired
    private Room_Repository roomRepository;
    @Autowired
    private PG_Repository pgRepository;

    // Add room
    public Room addRoom(Room room) {
        Integer pdId=room.getPg().getPgId();
        PG pg = pgRepository.findById(pdId).orElse(null);
        room.setPg(pg);
        return roomRepository.save(room);
    }


    // Get all rooms
    public List<Room> getAllRooms() {

        return roomRepository.findAll();
    }


    // Get room by ID
    public Room getRoomById(Integer roomId) {

        return roomRepository.findById(roomId).orElse(null);
    }


    // Update room
    public Room updateRoom(Integer roomId, Room room) {

        Room existingRoom = roomRepository.findById(roomId).orElse(null);

        if (existingRoom != null) {

            existingRoom.setRoomNumber(room.getRoomNumber());
            existingRoom.setRoomType(room.getRoomType());
            existingRoom.setPg(room.getPg());

            return roomRepository.save(existingRoom);
        }

        return null;
    }


    // Delete room
    public String deleteRoom(Integer roomId) {

        if (roomRepository.existsById(roomId)) {

            roomRepository.deleteById(roomId);

            return "Room deleted successfully";
        }

        return "Room not found";
    }
}