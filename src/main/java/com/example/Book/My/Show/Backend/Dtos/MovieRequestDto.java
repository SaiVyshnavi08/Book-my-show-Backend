package com.example.Book.My.Show.Backend.Dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieRequestDto {

    private String name;
    private Date releaseDate;
    private int duration;
}
