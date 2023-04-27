package com.example.Book.My.Show.Backend.Repository;

import com.example.Book.My.Show.Backend.Models.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TicketRepository extends JpaRepository<TicketEntity ,Integer> {

}
