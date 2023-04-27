package com.example.Book.My.Show.Backend.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="movies")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(nullable = false , unique = true)
    private String name;


    private Date releaseDate;

    private int duration;


       @OneToMany(mappedBy = "movieEntity" , cascade = CascadeType.ALL)
    private List<ShowsEntity> showsEntityList;

}
