package com.example.hotel_reservation.controller;

import com.example.hotel_reservation.model.Reservation;
import com.example.hotel_reservation.service.ReservationService;
import com.example.hotel_reservation.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reservation")
@AllArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;
    private final RoomService roomService;

    @GetMapping
    public String getAllReservation(Model model) {
        model.addAttribute("reservations", reservationService.getAllReservations());
        return "reservations";
    }

    @GetMapping("/new-date")
    public String createReservationDate(Model model){
        model.addAttribute("reservation", new Reservation());
        return "new-reservation-date";
    }

    @GetMapping("/new")
    public String createReservation(Model model, @ModelAttribute("reservation") Reservation reservation){
        model.addAttribute("reservation", new Reservation());
        model.addAttribute("rooms",roomService.getAllAvailableRooms(reservation.getStartDate(), reservation.getEndDate()));
        return "new-reservation";
    }
}
