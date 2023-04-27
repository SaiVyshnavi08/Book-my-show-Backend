package com.example.Book.My.Show.Backend.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="ticket")
@Data
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String allotedSeats;

    private int amount;

    private Date BookedAt;

    @ManyToOne
    @JoinColumn
    private UserEntity user;

    @ManyToOne
    @JoinColumn
    private ShowsEntity shows;

    @OneToMany(mappedBy = "ticket" , cascade = CascadeType.ALL)
    private List<ShowSeatsEntity> showSeatsList;
}
