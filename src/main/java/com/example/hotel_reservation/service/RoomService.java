package com.example.hotel_reservation.service;

import com.example.hotel_reservation.model.Reservation;
import com.example.hotel_reservation.model.Room;
import com.example.hotel_reservation.repo.RoomRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class RoomService {
    private final RoomRepo roomRepo;
    private final ReservationService reservationService;

    public List<Room> getAllRooms() {
        return roomRepo.findAll();
    }

    public Room getRoomById(Integer id) {
        return roomRepo.findById(id).orElse(null);
    }

    public List<Room> getAllAvailableRooms(LocalDate startDate, LocalDate endDate, Integer guestNumber) {
        List<Reservation> wrongReservations = reservationService.betweenDates(startDate,endDate);
        Set<Integer> wrongRoomId = new HashSet<>();
        for (Reservation actual: wrongReservations) {
            wrongRoomId.add(actual.getRoom().getId());
        }
        return roomRepo.findAllByIdNotInAndRoomCapacityGreaterThanEqual(wrongRoomId, guestNumber);
    }
}
