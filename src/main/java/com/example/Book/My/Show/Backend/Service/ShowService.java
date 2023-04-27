package com.example.Book.My.Show.Backend.Service;


import com.example.Book.My.Show.Backend.Dtos.ShowRequestDto;
import com.example.Book.My.Show.Backend.Models.*;
import com.example.Book.My.Show.Backend.Repository.MovieRepository;
import com.example.Book.My.Show.Backend.Repository.ShowRepository;
import com.example.Book.My.Show.Backend.Repository.ShowSeatsRepository;
import com.example.Book.My.Show.Backend.Repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {

    @Autowired
    ShowRepository showRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    ShowSeatsRepository showSeatsRepository;

    public String addShow(ShowRequestDto showRequestDto) {

        //ShowEntity
        ShowsEntity show = ShowsEntity.builder().showDate(showRequestDto.getShowDate()).showTime(showRequestDto.getShowTime()).multiplier(showRequestDto.getMultiplier()).build();


        //We should get the movie repository from that we should get the movie name

        MovieEntity movie = movieRepository.findMovieByName(showRequestDto.getMovieName());


        //we should add theater Repo and get the theater by name

        TheaterEntity theater = theaterRepository.findById(showRequestDto.getTheaterId()).get();

        // we have to set the movie name and theater id for that particular show thesrefore

        show.setMovieEntity(movie);
        show.setTheaterEntity(theater);

        List<ShowSeatsEntity> seatEntityList = createShowSeats(theater.getTheaterSeatsList());

        show.setShowSeatsEntityList(seatEntityList);

        show = showRepository.save(show);

        movie.getShowsEntityList().add(show);
        theater.getShowsEntityList().add(show);

        movieRepository.save(movie);
        theaterRepository.save(theater);

//        for(ShowSeatsEntity showSeat : seatEntityList) {
//            showSeat.setShowsEntity(show);
//        }
//        showRepository.save(show);
        return "Show added succesfully";
    }
        //We have to create the show seats

      public List<ShowSeatsEntity> createShowSeats(List<TheaterSeats> theaterSeatsList){

        List<ShowSeatsEntity> seats = new ArrayList<>();


        for(TheaterSeats theaterseats : theaterSeatsList){

            ShowSeatsEntity showSeats = ShowSeatsEntity.builder().SeatNo(theaterseats.getSeatNo()).seatType(theaterseats.getSeatType()).build();

            seats.add(showSeats);

        }
         showSeatsRepository.saveAll(seats);
        return seats;
    }
}
