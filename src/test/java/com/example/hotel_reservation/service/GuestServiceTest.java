package com.example.hotel_reservation.service;

import com.example.hotel_reservation.model.Guest;
import com.example.hotel_reservation.repo.GuestRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GuestServiceTest {

    @Mock
    private GuestRepo guestRepo;

    @InjectMocks
    private GuestService guestService;

    private Guest guest;

    @BeforeEach
    void setUp() {
        guest = new Guest(1,
                "Mr.",
                "Teszt",
                "Tamás",
                "Ózd", LocalDate.of(1985, 5, 12),
                "123456789",
                "tomci@progamtic.com");
    }

    @Test
    @DisplayName("Getting all guests")
    void testGetAllGuests() {
        List<Guest> guests = List.of(guest);

        when(guestRepo.findAll()).thenReturn(guests);

        List<Guest> result = guestService.getAllGuests();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("tomci@progamtic.com", result.get(0).getEmail());
    }

    @Test
    @DisplayName("Get existing guest by ID")
    void getGuestById() {
        when(guestRepo.findById(1)).thenReturn(Optional.of(guest));

        Guest result = guestService.getGuestById(1);

        verify(guestRepo).findById(1);
        assertEquals(guest, result);
    }

    @Test
    @DisplayName("Get guest by non existing ID")
    public void getGuestById_nonExistentId() {
        when(guestRepo.findById(1)).thenReturn(Optional.empty());

        Guest result = guestService.getGuestById(1);

        verify(guestRepo).findById(1);
        assertNull(result);
    }

    @Test
    @DisplayName("Save guest")
    public void saveGuest() {
        guestService.saveGuest(guest);

        verify(guestRepo).save(guest);
    }

    @Test
    @DisplayName("Update guest")
    void updateGuest() {
        guestService.updateGuest(guest);

        verify(guestRepo).save(guest);
    }
}