package com.example.hotel_reservation.controller;

import com.example.hotel_reservation.model.Reservation;
import com.example.hotel_reservation.service.GuestService;
import com.example.hotel_reservation.service.ReservationService;
import com.example.hotel_reservation.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reservation")
@AllArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;
    private final RoomService roomService;
    private final GuestService guestService;

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
        System.out.println(reservation);
        model.addAttribute("reservation", reservation);
        model.addAttribute("rooms", roomService.getAllAvailableRooms(
                reservation.getStartDate(),
                reservation.getEndDate(),
                reservation.getGuestNumber()));
        model.addAttribute("guests", guestService.getAllGuests());
        return "new-reservation";
    }

    @PostMapping("/new")
    public String createReservation(@ModelAttribute("reservation") Reservation reservation){
        reservationService.save(reservation);
        return "redirect:/reservation";
    }

    @PostMapping("/delete/{id}")
    public String deleteReservation(@PathVariable("id") Integer id){
        reservationService.deleteReservationById(id);
        return "redirect:/reservation";
    }
}
