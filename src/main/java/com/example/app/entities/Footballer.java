package com.example.app.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.ZonedDateTime;


@Entity
@Table(name = "pilkarz")
@Data
@XmlRootElement(name = "footballer")
@XmlAccessorType(XmlAccessType.FIELD)
public class Footballer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String imie;

    @Column(unique = true)
    private String nazwisko;

    @ManyToOne
    private Nationality narodowosc;

    @Column(unique = true)
    private int numer;

    @ManyToOne
    private Position pozycja;

    @ManyToOne
    private Club klubPilkarza;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name="data_dodania")
    private ZonedDateTime dataDodania;

}