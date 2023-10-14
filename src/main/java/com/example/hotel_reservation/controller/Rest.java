package com.example.hotel_reservation.controller;

import com.example.hotel_reservation.model.Guest;
import com.example.hotel_reservation.model.Reservation;
import com.example.hotel_reservation.model.Room;
import com.example.hotel_reservation.service.GuestService;
import com.example.hotel_reservation.service.ReservationService;
import com.example.hotel_reservation.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/rest")
@AllArgsConstructor
public class Rest {
    private final GuestService guestService;
    private final RoomService roomService;
    private final ReservationService reservationService;

    @GetMapping("/guests")
    public List<Guest> getAllGuests() {
        return guestService.getAllGuests();
    }

    @GetMapping("/rooms")
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    @GetMapping("/reservations")
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/available")
    public List<Room> getAvailable(){
        return roomService.getAllAvailableRooms(
                LocalDate.of(2023, 10, 1),
                LocalDate.of(2023,11,1), 3);
    }
}
