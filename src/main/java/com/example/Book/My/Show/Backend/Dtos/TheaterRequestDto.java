package com.example.Book.My.Show.Backend.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class TheaterRequestDto {

    private String name;
    private String city;
    private String address;
}
