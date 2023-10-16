package com.example.hotel_reservation.service;

import com.example.hotel_reservation.model.Guest;
import com.example.hotel_reservation.repo.GuestRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GuestService {
    private final GuestRepo guestRepo;

    public List<Guest> getAllGuests() {
        return guestRepo.findAll();
    }

    public Guest getGuestById(Integer id) {
        return guestRepo.findById(id).orElse(null);
    }

    public void saveGuest(Guest guest) {
        guestRepo.save(guest);
    }

    public void updateGuest(Guest guest) {
        guestRepo.save(guest);
    }
}
