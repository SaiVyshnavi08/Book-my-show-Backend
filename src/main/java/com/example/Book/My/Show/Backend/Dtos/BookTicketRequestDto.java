package com.example.Book.My.Show.Backend.Dtos;

import lombok.Data;

import java.util.List;

@Data

public class BookTicketRequestDto {

   private List<String> requestedSeats;        // what are the seat numbers that u want to book
   private int showId;          // to which show u want to book the ticket
   private int userId;      // who is the user that is booking the ticket

}
