package com.example.Book.My.Show.Backend.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ShowRequestDto {

   private LocalDate showDate;
    private LocalTime showTime;

    private String movieName;

    private int theaterId;

    private double multiplier;
}
