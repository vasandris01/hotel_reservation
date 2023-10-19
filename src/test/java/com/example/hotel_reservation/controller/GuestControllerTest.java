package com.example.hotel_reservation.controller;

import com.example.hotel_reservation.model.Guest;
import com.example.hotel_reservation.service.GuestService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class GuestControllerTest {
    private MockMvc mockMvc;

    @InjectMocks
    private GuestController guestController;

    @Mock
    private GuestService guestService;

    private Guest guest;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(guestController).build();

        guest = new Guest(1,
                "Mr.",
                "Teszt",
                "Tamás",
                "Ózd", LocalDate.of(1985, 5, 12),
                "123456789",
                "tomci@progamtic.com");
    }

    @Test
    void getAllGuests() throws Exception {
        when(guestService.getAllGuests()).thenReturn(List.of());
        mockMvc.perform(get("/guest"))
                .andExpect(status().isOk())
                .andExpect(view().name("guests"));
    }

    @Test
    void getGuestById() throws Exception {
        int guestId = 1;
        when(guestService.getGuestById(guestId)).thenReturn(guest);
        mockMvc.perform(get("/guest/" + guestId))
                .andExpect(status().isOk())
                .andExpect(view().name("show-guest"))
                .andExpect(model().attribute("guest", guest));
    }

    @Test
    void newGuest() throws Exception {
        mockMvc.perform(get("/guest/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("guest-form"))
                .andExpect(model().attributeExists("guest"))
                .andExpect(model().attribute("post_url", "/new"));
    }

    @Test
    void testNewGuest() throws Exception {
        mockMvc.perform(post("/guest/new")
                        .param("name", "Név"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/guest"));
    }

    @Test
    void editGuest() throws Exception {
        int guestId = 1;
        when(guestService.getGuestById(guestId)).thenReturn(guest);
        mockMvc.perform(get("/guest/edit/" + guestId))
                .andExpect(status().isOk())
                .andExpect(view().name("guest-form"))
                .andExpect(model().attribute("guest", guest))
                .andExpect(model().attribute("post_url", "/edit/" + guestId));

    }

    @Test
    void testEditGuest() throws Exception {
        int guestId = 1;
        mockMvc.perform(post("/guest/edit/" + guestId)
                        .param("name", "Új név")) // Provide the necessary parameters for editing
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/guest")); // Assum
    }
}