package com.hani.reservation;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservation")
@AllArgsConstructor
public class ControllerReservation {
    private ReservationService service;


    @PostMapping
    public Reservation saveReservation(@RequestBody Reservation reservation){
        return service.makeReservation(reservation);
    }
}
