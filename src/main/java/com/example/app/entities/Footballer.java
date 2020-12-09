package com.example.app.entities;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "pilkarz")
@Data
public class Footballer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pilkarz_id")
    private Long id;

    private String imie;
    private String nazwisko;
    private int narodowosc;
    private int pozycja;
    private int numer;

}