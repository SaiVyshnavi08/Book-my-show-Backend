package com.example.Book.My.Show.Backend.Service;

import com.example.Book.My.Show.Backend.Dtos.TheaterRequestDto;
import com.example.Book.My.Show.Backend.Enums.SeatType;
import com.example.Book.My.Show.Backend.Models.TheaterEntity;
import com.example.Book.My.Show.Backend.Models.TheaterSeats;
import com.example.Book.My.Show.Backend.Repository.TheaterRepository;
import com.example.Book.My.Show.Backend.Repository.TheaterSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class TheaterService {

    @Autowired
    TheaterRepository theaterRepository;

@Autowired
TheaterSeatRepository theaterSeatRepository;

    public String addTheater(TheaterRequestDto theaterRequestDto){
        TheaterEntity theater = TheaterEntity.builder()
                .name(theaterRequestDto.getName())
                .City(theaterRequestDto.getCity())
                .address(theaterRequestDto.getAddress())
                .build();

        List<TheaterSeats> theaterSeatList = createTheaterSeats();

        theater.setTheaterSeatsList(theaterSeatList); // this is our ultimate goal for create theater seats function

        //for every theater seat we need to map it to that corresponding theater

        for(TheaterSeats theaterseat : theaterSeatList){
            theaterseat.setTheaterEntity(theater);
        }

        theaterRepository.save(theater);

        return "Theater added Successfully";
    }

    private List<TheaterSeats> createTheaterSeats(){
        List<TheaterSeats> SeatList = new ArrayList<>();

        TheaterSeats seat1 = new TheaterSeats("1A" , SeatType.CLASSIC , 100);
        TheaterSeats seat2 = new TheaterSeats("1B" , SeatType.CLASSIC , 100);
        TheaterSeats seat3 = new TheaterSeats("1C" , SeatType.CLASSIC , 100);
        TheaterSeats seat4 = new TheaterSeats("1D" , SeatType.CLASSIC , 100);
        TheaterSeats seat5 = new TheaterSeats("1E" , SeatType.CLASSIC , 100);

        TheaterSeats seat6 = new TheaterSeats("2A" , SeatType.PLATINUM , 200);
        TheaterSeats seat7 = new TheaterSeats("2B" , SeatType.PLATINUM , 200);
        TheaterSeats seat8 = new TheaterSeats("2C" , SeatType.PLATINUM , 200);
        TheaterSeats seat9 = new TheaterSeats("2D" , SeatType.PLATINUM , 200);
        TheaterSeats seat10 = new TheaterSeats("2E" , SeatType.PLATINUM , 200);


        SeatList.add(seat1);
        SeatList.add(seat2);
        SeatList.add(seat3);
        SeatList.add(seat4);
        SeatList.add(seat5);
        SeatList.add(seat6);
        SeatList.add(seat7);
        SeatList.add(seat8);
        SeatList.add(seat9);
        SeatList.add(seat10);

        theaterSeatRepository.saveAll(SeatList);

        return SeatList;

    }

    public TheaterEntity getTheaterByName(String name){

        return theaterRepository.findTheaterByName(name);
    }



    public List<String> TheaterList(){

        List<TheaterEntity> theaters = theaterRepository.findAll();

        List<String> TheaterNames = new ArrayList<>();

        for(TheaterEntity theater : theaters){
            TheaterNames.add(theater.getName());
        }
        return TheaterNames;
    }
}
