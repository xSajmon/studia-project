package com.example.app.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.ZonedDateTime;


@Entity
@Table(name = "pilkarz")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Footballer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String imie;

    @Column(unique = true)
    private String nazwisko;

    @ManyToOne
    private Nationality narodowosc;


    private int numer;

    @ManyToOne
    private Position pozycja;

    @ManyToOne
    private Club klubPilkarza;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name="data_dodania")
    private ZonedDateTime dataDodania;

}