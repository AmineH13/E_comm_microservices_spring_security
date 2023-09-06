package com.hani.vol;


import com.hani.vol.exception.VolNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service  @AllArgsConstructor
public class VolService {

    private VolRepository repository;



    public Vol saveVol(Vol vol){
        return repository.save(vol);
    }

    public List<Vol> getAllVols(){
        return repository.findAll();
    }


    public Vol getVol(Long id_vol) {
        Optional<Vol> vol = repository.findById(id_vol);
        return vol.orElseThrow(() ->new VolNotFoundException("Oups vol dosent exist ..."));
    }

    public void updateVol(Long id_vol, int nbr_seats_full){
        Vol vol=repository.findById(id_vol).get();
        vol.setNbr_empty_seats(vol.getNbr_empty_seats()-nbr_seats_full);
        this.saveVol(vol);
    }
}
