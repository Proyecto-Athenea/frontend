package com.example.reto3atenea.Controller;

import com.example.reto3atenea.Model.Reservation;
import com.example.reto3atenea.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/Reservation")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all") // ->>>> localhost......./api/
    public List<Reservation> getAll(){
        return reservationService.getAll();
    }

    @GetMapping("/{id}") // ->>>>>>> localhost......../api/reservation/12
    public Optional<Reservation> getReservation (@PathVariable int id){
        return reservationService.getReservation(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation){
        return reservationService.save(reservation);
    }
}
