package com.example.hotel_reservation.service;

import com.example.hotel_reservation.model.Reservation;
import com.example.hotel_reservation.repo.ReservationRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReservationService {
    private final ReservationRepo reservationRepo;

    public List<Reservation> getAllReservations() {
        return reservationRepo.findAll();
    }
}
