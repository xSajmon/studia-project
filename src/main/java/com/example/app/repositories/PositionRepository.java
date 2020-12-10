package com.example.app.repositories;

import com.example.app.entities.Position;
import org.springframework.data.repository.CrudRepository;



public interface PositionRepository extends CrudRepository<Position, Long> {
}
