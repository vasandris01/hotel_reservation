package com.example.hotel_reservation.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer roomNumber;
    private Integer roomCapacity;
    private Integer price;
    private Boolean hasJacuzzi;
    private Boolean hasSauna;
    @OneToMany(mappedBy = "room")
    @JsonBackReference
    private List<Reservation> reservations;
}
