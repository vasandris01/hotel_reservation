package com.example.hotel_reservation.controller;

import com.example.hotel_reservation.model.Guest;
import com.example.hotel_reservation.service.GuestService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/new")
    public String newGuest(Model model){
        model.addAttribute("guest", new Guest());
        model.addAttribute("post_url", "/new");
        return "guest-form";
    }
    @PostMapping("/new")
    public String newGuest(@ModelAttribute("guest") Guest guest){
        guestService.saveGuest(guest);
        return "redirect:/guest";
    }

    @GetMapping("/edit/{id}")
    public String editGuest(Model model, @PathVariable("id") Integer id){
        model.addAttribute("guest", guestService.getGuestById(id));
        model.addAttribute("post_url", "/edit/" + id);
        return "guest-form";
    }

    @PostMapping("/edit/{id}")
    public String editGuest(@ModelAttribute("guest") Guest guest){
        guestService.updateGuest(guest);
        return "redirect:/guest";
    }
}
