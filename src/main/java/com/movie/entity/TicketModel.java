package com.movie.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "ticket")
public class TicketModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketId;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private movieModel movie;

    @Column(nullable = false)
    private String seatNo;

    @Column(nullable = false)
    private String row;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String theaterName;

    @Column(nullable = false)
    private LocalDateTime time;


    public TicketModel(movieModel movie, String seatNo, String row, String location, String theaterName, LocalDateTime time) {
        this.movie = movie;
        this.seatNo = seatNo;
        this.row = row;
        this.location = location;
        this.theaterName = theaterName;
        this.time = time;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public movieModel getMovie() {
        return movie;
    }

    public void setMovie(movieModel movie) {
        this.movie = movie;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
