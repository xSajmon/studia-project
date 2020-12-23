package com.example.app.repositories;

import com.example.app.entities.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PositionRepository extends CrudRepository<Position, Long>, JpaRepository<Position, Long> {

    Position findByPozycja(String pozycja);
}
