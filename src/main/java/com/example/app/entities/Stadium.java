package com.example.app.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "stadion")
@Data
public class Stadium {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String nazwa;

    @OneToOne(mappedBy = "stadion")
    private Club klub;
}
