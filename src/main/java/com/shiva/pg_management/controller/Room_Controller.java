package com.shiva.pg_management.controller;

import com.shiva.pg_management.entity.Room;
import com.shiva.pg_management.service.Room_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class Room_Controller {

    @Autowired
    private Room_Service roomService;


    // 1. Add room
    @PostMapping("/add")
    public ResponseEntity<Room> addRoom(@RequestBody Room room) {

        return ResponseEntity.ok(roomService.addRoom(room));
    }


    // 2. Get all rooms
    @GetMapping("/getAll")
    public ResponseEntity<List<Room>> getAllRooms() {

        return ResponseEntity.ok(roomService.getAllRooms());
    }


    // 3. Get room by ID
    @GetMapping("/get/{roomId}")
    public ResponseEntity<Room> getRoomById(
            @PathVariable Integer roomId) {

        return ResponseEntity.ok(roomService.getRoomById(roomId));
    }


    // 4. Update room
    @PutMapping("/update/{roomId}")
    public ResponseEntity<Room> updateRoom(
            @PathVariable Integer roomId,
            @RequestBody Room room) {

        return ResponseEntity.ok(
                roomService.updateRoom(roomId, room)
        );
    }


    // 5. Delete room
    @DeleteMapping("/delete/{roomId}")
    public ResponseEntity<String> deleteRoom(
            @PathVariable Integer roomId) {

        return ResponseEntity.ok(
                roomService.deleteRoom(roomId)
        );
    }
}