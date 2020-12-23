package com.example.app.repositories;

import com.example.app.entities.Coach;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoachRepository extends CrudRepository<Coach, Long> {
}
