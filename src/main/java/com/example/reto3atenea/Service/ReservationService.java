package com.example.reto3atenea.Service;

import com.example.reto3atenea.Model.Reservation;
import com.example.reto3atenea.Repository.CRUD.ReservationCrudRepository;
import com.example.reto3atenea.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    public List<Reservation> getAll(){
        return reservationRepository.findAll();
    }

    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }

    public Reservation save(Reservation reservation){
        if (reservation.getIdReservation()==null){
            return reservationRepository.save(reservation);
        }else{
            Optional<Reservation> reservationEcontrado = getReservation(reservation.getIdReservation());
            if(reservationEcontrado.isEmpty()) {
                return reservationRepository.save(reservation);
            }else {
                return reservation;
            }
        }
    }
    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation>reservationEncontrado = getReservation(reservation.getIdReservation());
            if(reservationEncontrado.isPresent()){
                if(reservation.getStartDate()!=null){
                    reservationEncontrado.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    reservationEncontrado.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    reservationEncontrado.get().setStatus(reservation.getStatus() );
                }

                return reservationRepository.save(reservationEncontrado.get());
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }
    public boolean deleteReservation(int id){
        Boolean respuesta = getReservation(id).map(reservation  -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        return respuesta;
    }

}
