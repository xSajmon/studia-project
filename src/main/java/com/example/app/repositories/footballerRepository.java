package com.example.app.repositories;

import com.example.app.entities.Footballer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface footballerRepository  extends CrudRepository<Footballer, Long> {




}
