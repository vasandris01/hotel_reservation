package com.example.hotel_reservation.service;

import com.example.hotel_reservation.model.Reservation;
import com.example.hotel_reservation.repo.ReservationRepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class ReservationService {
    private final ReservationRepo reservationRepo;

    public List<Reservation> getAllReservations() {
        return reservationRepo.findAll();
    }

    public List<Reservation> betweenDates(LocalDate start, LocalDate end) {
        return reservationRepo.findAllByStartDateIsBetweenOrEndDateIsBetween(start, end, start, end);
    }

    public void save(Reservation reservation) {
        reservationRepo.save(reservation);
    }

    @Transactional
    public void deleteReservationById(Integer id) {
        reservationRepo.removeById(id);
    }
}
