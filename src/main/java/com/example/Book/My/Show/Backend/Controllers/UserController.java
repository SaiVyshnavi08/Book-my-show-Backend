package com.example.Book.My.Show.Backend.Controllers;


import com.example.Book.My.Show.Backend.Dtos.UserRequestDto;
import com.example.Book.My.Show.Backend.Models.UserEntity;
import com.example.Book.My.Show.Backend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping("/addUser")
    public String addUser (@RequestBody()UserRequestDto userRequestDto){

        return userService.addUser(userRequestDto);
    }

    @GetMapping("/getUser")
    public UserEntity getUser(@RequestParam String name) {
        return userService.getUserByName(name);
    }

     public List<String> AllUsers(){
         return userService.allUsers();

        }
    }

