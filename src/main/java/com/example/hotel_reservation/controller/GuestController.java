package com.example.hotel_reservation.controller;

import com.example.hotel_reservation.model.Guest;
import com.example.hotel_reservation.service.GuestService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/guest")
@AllArgsConstructor
public class GuestController {
    private final GuestService guestService;

    @GetMapping
    public String getAllGuests(Model model) {
        model.addAttribute("guests", guestService.getAllGuests());
        return "guests";
    }

    @GetMapping("/{id}")
    public String getGuestById(@PathVariable("id") Integer id, Model model){
        model.addAttribute("guest", guestService.getGuestById(id));
        return "show-guest";
    }
}
