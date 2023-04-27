package com.example.Book.My.Show.Backend.Models;


import com.example.Book.My.Show.Backend.Enums.SeatType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="theater_seats")
@Data
@NoArgsConstructor
public class TheaterSeats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String seatNo;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    private int rate;


    @ManyToOne
    @JoinColumn
    private TheaterEntity theaterEntity;


    public TheaterSeats(String seatNo , SeatType seatType , int rate){
        this.seatNo = seatNo;
        this.seatType = seatType;
        this.rate = rate;
    }
}
