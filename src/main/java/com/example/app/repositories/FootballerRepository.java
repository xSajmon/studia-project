package com.example.app.repositories;

import com.example.app.entities.Footballer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FootballerRepository  extends JpaRepository<Footballer, Long> {
    Footballer findByNazwisko(String nazwisko);
    boolean existsByNazwisko(String nazwisko);
    boolean existsByKlubPilkarzaIsNull();



    // *POLECENIA*

    @Query("select f " +
            "from Footballer f " +
            "inner join Position p on f.pozycja = p " +
            "where p.pozycja = ?1 ")
    List<Footballer> findAllByPozycja(String nazwa);

    @Query("select f.nazwisko, f.numer " +
            "from Footballer f " +
            "where f.numer = (select max(f.numer) from Footballer f)")
    String highestNumber();

    @Query("select f " +
            "from Footballer f " +
            "inner join Nationality n on f.narodowosc = n " +
            "where n.narodowosc = ?1")
    List<Footballer> findAllByNarodowosc(String narodowosc, Pageable p);

    @Query("select concat(f.imie, ' ',f.nazwisko) as pilkarz " +
            "from Footballer f " +
            "inner join Nationality n on f.narodowosc = n " +
            "inner join Position p on f.pozycja = p " +
            "where n.narodowosc = ?1 and p.pozycja = ?2")
    List findAllByNarodowoscAndPozycja(String narodowosc, String pozycja);

    List<Footballer> findByOrderByNumer();






}
