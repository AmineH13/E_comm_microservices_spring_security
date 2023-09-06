package com.hani.vol;


import com.hani.vol.exception.VolNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vol")
@AllArgsConstructor
public class VolController {

    private VolService service;

    @GetMapping
    public ResponseEntity<List<Vol>> getAllVols(){
        return new ResponseEntity<>(service.getAllVols(), HttpStatus.OK);
    }

    @GetMapping("/{id_vol}")
    public ResponseEntity<Vol> getVol(@PathVariable("id_vol") Long id_vol){
        return new ResponseEntity<>(service.getVol(id_vol), HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<Vol> saveVol(@RequestBody Vol vol){
        return new ResponseEntity<>(service.saveVol(vol), HttpStatus.CREATED) ;
    }

    @GetMapping("/nbr_empty_seats/{id_vol}")
    public int getNbrEmptySeats(@PathVariable("id_vol") Long id_vol){
        return service.getVol(id_vol).getNbr_empty_seats();
    }

    @PutMapping("/after_reservation/{id_vol}/{nbr_seats}")
    public void updateVol(@PathVariable("id_vol") Long id_vol, @PathVariable("nbr_seats") int nbr_seats){
         service.updateVol(id_vol,nbr_seats);
    }

    @GetMapping("/checkExistance/{id_vol}")
    public int checkExistance(@PathVariable("id_vol") Long id_vol)
    {
        try{
            service.getVol(id_vol);
            return 1;
        }catch (VolNotFoundException e)
        {
            return 0;
        }
    }


}
