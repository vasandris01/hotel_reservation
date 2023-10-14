package com.example.hotel_reservation.repo;

import com.example.hotel_reservation.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationRepo extends JpaRepository<Reservation, Integer> {
    List<Reservation> findAllByStartDateIsBetweenOrEndDateIsBetween(LocalDate start, LocalDate end,LocalDate startD, LocalDate endD);
}
