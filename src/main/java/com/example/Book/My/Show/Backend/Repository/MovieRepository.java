package com.example.Book.My.Show.Backend.Repository;

import com.example.Book.My.Show.Backend.Models.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<MovieEntity , Integer> {

    MovieEntity findMovieByName(String name);
}
