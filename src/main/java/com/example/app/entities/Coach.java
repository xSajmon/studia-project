package com.example.app.entities;

import com.example.app.entities.Club;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "trener")
@Data
public class Coach {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;



}
