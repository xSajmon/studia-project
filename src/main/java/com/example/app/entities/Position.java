package com.example.app.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pozycja")
@Data
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String pozycja;

    @OneToMany(mappedBy = "pozycja")
    private Set<Footballer> pilkarze = new HashSet<>();



}
