package com.hani.reservation;

import com.hani.reservation.client.VolClient;
import com.hani.reservation.exception.NbrSeatNotEnoughException;
import com.hani.reservation.exception.VolNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service @AllArgsConstructor
public class ReservationService {

    private ReservationRepository repository;
    private VolClient volClient;


    @PostMapping
    public Reservation makeReservation(@RequestBody Reservation reservation){
        int existanceVol = volClient.checkExistance(reservation.getVol_id());
        if(existanceVol == 0) throw  new VolNotFoundException("Vol dosent existe ...");
        int nbr_empty_seats=volClient.nbrEmptySeats(reservation.getVol_id());
        if (nbr_empty_seats >= reservation.getNbr_seat()){
            volClient.updateVol(reservation.getVol_id(), reservation.getNbr_seat());
            return repository.save(reservation);
        }
        throw new NbrSeatNotEnoughException("Impossible to make this reservation, seats not enough ...");
    }

}
