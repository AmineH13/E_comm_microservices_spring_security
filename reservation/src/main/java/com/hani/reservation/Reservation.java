package com.hani.reservation;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Entity
public class Reservation {
    @Id
    private Long id_reservation;
    private int nbr_seat;
    private Long vol_id;
    private String passager_name;
}
