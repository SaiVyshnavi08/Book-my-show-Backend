package com.example.Book.My.Show.Backend.Controllers;


import com.example.Book.My.Show.Backend.Dtos.MovieRequestDto;
import com.example.Book.My.Show.Backend.Models.MovieEntity;
import com.example.Book.My.Show.Backend.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    MovieService movieService;


      @PostMapping("/addMovie")
    public String addMovie(@RequestBody()MovieRequestDto movieRequestDto){
           return movieService.addMovie(movieRequestDto);
      }

      @GetMapping("/getMovie")
    public MovieEntity getMovie(@RequestParam String name){
        return movieService.getMovie(name);
      }

      public List<String> allMovieNames(){            // get all the list of movies in mysql
          return movieService.getAllMovieNames();
      }
}
