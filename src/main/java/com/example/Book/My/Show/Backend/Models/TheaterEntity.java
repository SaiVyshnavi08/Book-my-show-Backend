package com.example.Book.My.Show.Backend.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name ="Theater")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class TheaterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String City;

    private String address;

    @OneToMany(mappedBy = "theaterEntity" ,cascade = CascadeType.ALL)
    private List<TheaterSeats> theaterSeatsList;

    @OneToMany(mappedBy="theaterEntity" , cascade = CascadeType.ALL)
    private List<ShowsEntity> showsEntityList;


}
