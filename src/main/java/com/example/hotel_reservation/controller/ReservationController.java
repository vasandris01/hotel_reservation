package com.example.hotel_reservation.controller;

import com.example.hotel_reservation.service.ReservationService;
import com.example.hotel_reservation.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reservation")
@AllArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;

    @GetMapping
    public String getAllReservation(Model model) {
        model.addAttribute("reservations", reservationService.getAllReservations());
        return "reservations";
    }
}
