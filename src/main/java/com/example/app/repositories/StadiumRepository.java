package com.example.app.repositories;

import com.example.app.entities.Stadium;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StadiumRepository extends CrudRepository<Stadium, Long> {
}
