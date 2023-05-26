package com.example.reto3atenea.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name="score")
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idScore;

    private String messageText;

    private Integer stars;

    //Reservas
    @OneToOne
    @JsonIgnoreProperties("score")
    private Reservation reservations;

    public Score(Integer idScore, String messageText, Integer stars, Reservation reservations) {
        this.idScore = idScore;
        this.messageText = messageText;
        this.stars = stars;
        this.reservations = reservations;
    }


    public Integer getIdScore() {
        return idScore;
    }

    public void setIdScore(Integer idScore) {
        this.idScore = idScore;
    }

    public String getMessageText() {
        return this.messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public Reservation getReservations() {
        return reservations;
    }

    public void setReservations(Reservation reservations) {
        this.reservations = reservations;
    }

    public Score() {

    }
}
