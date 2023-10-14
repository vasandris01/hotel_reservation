package com.example.hotel_reservation.repo;

import com.example.hotel_reservation.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepo extends JpaRepository<Room,Integer> {
}
