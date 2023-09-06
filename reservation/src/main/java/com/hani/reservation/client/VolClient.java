package com.hani.reservation.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "vol-service", url = "${application.config.vols-url}")

public interface VolClient  {
    @GetMapping("/nbr_empty_seats/{id_vol}")
    public int nbrEmptySeats(@PathVariable("id_vol") Long id_vol);

    @PutMapping("/after_reservation/{id_vol}/{nbr_seats}")
    public void updateVol(@PathVariable("id_vol") Long id_vol, @PathVariable("nbr_seats") int nbr_seats);


    @GetMapping("/checkExistance/{id_vol}")
    public int checkExistance(@PathVariable("id_vol") Long id_vol);

}
