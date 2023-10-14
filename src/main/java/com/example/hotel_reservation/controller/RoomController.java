package com.example.hotel_reservation.controller;

import com.example.hotel_reservation.service.GuestService;
import com.example.hotel_reservation.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/room")
@AllArgsConstructor
public class RoomController {
    private final RoomService roomService;

    @GetMapping
    public String getAllRooms(Model model) {
        model.addAttribute("rooms", roomService.getAllRooms());
        return "rooms";
    }

    @GetMapping("/{id}")
    public String getRoomById(@PathVariable("id") Integer id, Model model){
        model.addAttribute("room", roomService.getRoomById(id));
        return "show-room";
    }
}
