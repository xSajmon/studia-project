package com.example.app.repositories;

import com.example.app.entities.Club;
import org.springframework.data.repository.CrudRepository;

public interface ClubRepository extends CrudRepository<Club, Long> {
}
