package com.example.Book.My.Show.Backend.Controllers;

import com.example.Book.My.Show.Backend.Dtos.BookTicketRequestDto;
import com.example.Book.My.Show.Backend.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    TicketService ticketService;

     @PostMapping("/bookTicket")
    public String bookTicket(@RequestBody BookTicketRequestDto bookTicketRequestDto){

         try{
             return ticketService.bookTicket(bookTicketRequestDto);
         }catch(Exception e){
             return e.getMessage();
         }

     }
}
