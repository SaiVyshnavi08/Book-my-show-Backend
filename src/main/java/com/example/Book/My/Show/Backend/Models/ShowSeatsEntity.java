package com.example.Book.My.Show.Backend.Models;


import com.example.Book.My.Show.Backend.Enums.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;

import java.util.Date;

@Entity
@Table(name="show_seats")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ShowSeatsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int rate;
    private String SeatNo;
    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;
    private boolean Booked;


    private Date BookedAt;

    @ManyToOne
    @JoinColumn
    private ShowsEntity showsEntity;

    @ManyToOne
    @JoinColumn
    private TicketEntity ticket;

}
