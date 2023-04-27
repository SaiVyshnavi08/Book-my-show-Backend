package com.example.Book.My.Show.Backend.Service;


import com.example.Book.My.Show.Backend.Dtos.MovieRequestDto;
import com.example.Book.My.Show.Backend.Models.MovieEntity;
import com.example.Book.My.Show.Backend.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public String addMovie(MovieRequestDto movieRequestDto){


        // here the movie req dto is being converted into the entity to just save into repo as it will not take dtos directly
        MovieEntity movie = MovieEntity.builder().name(movieRequestDto.getName()).releaseDate(movieRequestDto.getReleaseDate()).duration(movieRequestDto.getDuration()).build();

        movieRepository.save(movie);
        return "movie added succesfully";
    }

    public MovieEntity getMovie(String name){

        return movieRepository.findMovieByName(name);
    }

    public List<String> getAllMovieNames(){
        List<MovieEntity> Movies = movieRepository.findAll();

        List<String> MovieNames = new ArrayList<>();

        for(MovieEntity movies : Movies){
            MovieNames.add(movies.getName());

        }
        return MovieNames;
    }
}
