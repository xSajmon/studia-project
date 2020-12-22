package com.example.app.repositories;

import com.example.app.entities.Nationality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface NationalityRepository extends CrudRepository<Nationality, Long>, JpaRepository<Nationality,Long> {
    boolean existsByNarodowosc(String narodowosc);
    Nationality findByNarodowosc(String narodowosc);

}
