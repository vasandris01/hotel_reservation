package com.example.hotel_reservation.repo;

import com.example.hotel_reservation.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepo extends JpaRepository<Guest,Integer> {

}
