package com.example.Book.My.Show.Backend.Service;

import com.example.Book.My.Show.Backend.Dtos.BookTicketRequestDto;
import com.example.Book.My.Show.Backend.Models.ShowSeatsEntity;
import com.example.Book.My.Show.Backend.Models.ShowsEntity;
import com.example.Book.My.Show.Backend.Models.TicketEntity;
import com.example.Book.My.Show.Backend.Models.UserEntity;
import com.example.Book.My.Show.Backend.Repository.ShowRepository;
import com.example.Book.My.Show.Backend.Repository.TicketRepository;
import com.example.Book.My.Show.Backend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service

public class TicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    ShowRepository showRepository;

    @Autowired
    UserRepository userRepository;

    public String bookTicket(BookTicketRequestDto bookTicketRequestDto)throws Exception{


        //Firstly get the requested seats list

        List<String> requestedSeats =bookTicketRequestDto.getRequestedSeats();

        // get full showEntity object and userEntity object from repo by using the id we have

        ShowsEntity show = showRepository.findById(bookTicketRequestDto.getShowId()).get();

        UserEntity user = userRepository.findById(bookTicketRequestDto.getUserId()).get();

        //get showSeats from show

        List<ShowSeatsEntity> showSeats = show.getShowSeatsEntityList();

        // check if I can allocate the seats that are requested by the user( see if they are booked or not)

        List<ShowSeatsEntity> bookedSeats = new ArrayList<>();

        for(ShowSeatsEntity showSeat : showSeats){

            String seatNo = showSeat.getSeatNo();

            if(showSeat.isBooked() == false && requestedSeats.contains(seatNo)){
                bookedSeats.add(showSeat);
            }
        }
       // if the user requested seats were not available    //FAILURE
          if(bookedSeats.size() != requestedSeats.size()){
              throw new Exception("Requested seats are not available");
          }

          //if we are standing here that means the user requested seats were available    //SUCCESS
        TicketEntity ticket = new TicketEntity();
         double TotalAmount =0;
          double multiplier = show.getMultiplier();

          String allotedSeats ="";

        int rate = 0;
        //Therefore we are calculating the amount , Setting the Booked Status

        for(ShowSeatsEntity bookedSeat : bookedSeats){

            bookedSeat.setBooked(true);
            bookedSeat.setBookedAt(new Date());
            bookedSeat.setTicket(ticket);
            bookedSeat.setShowsEntity(show);
            String seatNo =bookedSeat.getSeatNo();

            allotedSeats = allotedSeats + seatNo + ",";

            TotalAmount = TotalAmount + multiplier*bookedSeat.getRate();

            if(seatNo.charAt(0)=='1')
                rate = 100;
            else
                rate = 200;

            TotalAmount = TotalAmount + multiplier*rate;
        }

        ticket.setBookedAt(new Date());
        ticket.setUser(user);
        ticket.setShows(show);
        ticket.setAmount((int)TotalAmount);
        ticket.setShowSeatsList(bookedSeats);
        ticket.setAllotedSeats(allotedSeats);

         ticketRepository.save(ticket);

         return " Succesfully Booked a ticket";

    }
}
