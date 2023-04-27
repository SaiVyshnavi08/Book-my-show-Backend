package com.example.Book.My.Show.Backend.Controllers;

import com.example.Book.My.Show.Backend.Dtos.TheaterRequestDto;
import com.example.Book.My.Show.Backend.Models.TheaterEntity;
import com.example.Book.My.Show.Backend.Service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theater")

public class TheaterController {

    @Autowired
    TheaterService theaterService;

    @PostMapping("/addTheater")
        public String AddTheater(@RequestBody TheaterRequestDto theaterRequestDto) {
          return theaterService.addTheater(theaterRequestDto) ;
    }
    @GetMapping("/getTheater")
    public TheaterEntity GetTheater(@RequestParam String name ){
        return theaterService.getTheaterByName(name);
    }

   public List<String> allTheaters(){
     return theaterService.TheaterList();
    }

}
