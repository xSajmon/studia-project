package com.example.app.entities;

import lombok.*;

import javax.persistence.*;
import java.time.ZonedDateTime;


@Entity
@Table(name = "pilkarz")
@Data
public class Footballer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String imie;
    private String nazwisko;

    @ManyToOne
    private Nationality narodowosc;

    private int numer;

    @ManyToOne
    private Position pozycja;

    @ManyToOne
    private Club klubPilkarza;

    @Column(name="data_dodania")
    private ZonedDateTime dataDodania;

}