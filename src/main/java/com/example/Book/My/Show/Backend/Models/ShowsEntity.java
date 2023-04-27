package com.example.Book.My.Show.Backend.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name ="shows")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ShowsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double multiplier;

    private LocalDate showDate;

    private LocalTime showTime;

    @CreationTimestamp
    private Date createdOn;

    @CreationTimestamp
    private Date UpdatedOn;

    @ManyToOne
    @JoinColumn
    private MovieEntity movieEntity;


    @ManyToOne
    @JoinColumn
    private TheaterEntity theaterEntity;

    @OneToMany(mappedBy = "showsEntity" , cascade = CascadeType.ALL)
    List<ShowSeatsEntity> showSeatsEntityList;

    @OneToMany(mappedBy = "shows" ,cascade = CascadeType.ALL)
    private List<TicketEntity> TicketsList;
}
