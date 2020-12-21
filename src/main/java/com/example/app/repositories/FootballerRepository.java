package com.example.app.repositories;

import com.example.app.entities.Footballer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface FootballerRepository  extends CrudRepository<Footballer, Long>, JpaRepository<Footballer,Long> {
    Footballer findByNazwisko(String nazwisko);
    boolean existsByNazwisko(String nazwisko);

}
