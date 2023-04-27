package com.example.Book.My.Show.Backend.Service;


import com.example.Book.My.Show.Backend.Dtos.UserRequestDto;
import com.example.Book.My.Show.Backend.Models.UserEntity;
import com.example.Book.My.Show.Backend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public String addUser(UserRequestDto userRequestDto){

        // we converted the userRequestDto to entity
        UserEntity user = UserEntity.builder().name(userRequestDto.getName()).mobile(userRequestDto.getMobile()).build();

        try{
           userRepository.save(user);
        }
        catch(Exception e){
          return "User cannot be added" ;
        }
        return "user added Succesfully";
    }
    public UserEntity getUserByName(String name){

        return userRepository.findUserByName(name);

    }

    public List<String> allUsers(){
        List<UserEntity> UserEntities = userRepository.findAll();

        List<String> UserNames = new ArrayList<>();

        for(UserEntity users : UserEntities){
            UserNames.add(users.getName());

        }
        return UserNames;
    }

}
