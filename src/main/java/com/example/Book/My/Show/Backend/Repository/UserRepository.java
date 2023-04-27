package com.example.Book.My.Show.Backend.Repository;

import com.example.Book.My.Show.Backend.Models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    UserEntity findUserByName(String name);
}
