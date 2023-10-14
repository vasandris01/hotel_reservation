package com.example.hotel_reservation.service;

import com.example.hotel_reservation.model.Room;
import com.example.hotel_reservation.repo.RoomRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoomService {
    private final RoomRepo roomRepo;

    public List<Room> getAllRooms() {
        return roomRepo.findAll();
    }

    public Room getRoomById(Integer id) {
        return roomRepo.findById(id).orElse(null);
    }
}
