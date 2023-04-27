package com.example.Book.My.Show.Backend.Repository;

import com.example.Book.My.Show.Backend.Models.ShowsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<ShowsEntity ,Integer> {
}
