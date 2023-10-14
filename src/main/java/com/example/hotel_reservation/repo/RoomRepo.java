package com.example.hotel_reservation.repo;

import com.example.hotel_reservation.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Repository
public interface RoomRepo extends JpaRepository<Room,Integer> {
    List<Room> findAllByIdNotInAndRoomCapacityGreaterThanEqual(Collection<Integer> ids, Integer guestNumber);
}
