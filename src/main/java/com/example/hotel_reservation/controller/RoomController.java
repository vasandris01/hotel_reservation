package com.example.hotel_reservation.controller;

import com.example.hotel_reservation.model.Room;
import com.example.hotel_reservation.service.GuestService;
import com.example.hotel_reservation.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/edit/{id}")
    public String editRoom(Model model, @PathVariable("id") Integer id){
        model.addAttribute("room", roomService.getRoomById(id));
        return "room-form";
    }

    @PostMapping("/edit/{id}")
    public String editRoom(@ModelAttribute("room") Room room){
        roomService.updateRoom(room);
        return "redirect:/room";
    }
}
