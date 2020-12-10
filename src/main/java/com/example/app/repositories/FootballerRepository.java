package com.example.app.repositories;

import com.example.app.entities.Footballer;
import org.springframework.data.repository.CrudRepository;



public interface FootballerRepository  extends CrudRepository<Footballer, Long> {

}
