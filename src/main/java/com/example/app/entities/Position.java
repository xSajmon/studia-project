package com.example.app.entities;

import javax.persistence.*;

@Entity
public class Position {

    @Id
    @Column(name = "pozycja_id")
    private Long id;


}
