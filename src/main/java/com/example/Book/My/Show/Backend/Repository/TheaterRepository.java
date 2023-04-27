package com.example.Book.My.Show.Backend.Repository;


import com.example.Book.My.Show.Backend.Models.TheaterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterRepository extends JpaRepository<TheaterEntity, Integer> {

    TheaterEntity findTheaterByName(String name);
}
