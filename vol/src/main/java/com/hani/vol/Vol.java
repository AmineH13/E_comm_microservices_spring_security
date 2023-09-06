package com.hani.vol;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Vol {
    @Id
    private Long id_vol;
    private String plane_name;
    private int nbr_seat;
    private int nbr_empty_seats;


    public Vol(Long id_vol, String plane_name, int nbr_seat) {
        this.id_vol = id_vol;
        this.plane_name = plane_name;
        this.nbr_seat = nbr_seat;
        this.nbr_empty_seats=nbr_seat;
    }

}
