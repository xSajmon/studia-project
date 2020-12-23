package com.example.app.entities;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "narodowosc")
@Data
public class Nationality {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonValue
    private String narodowosc;

    @OneToMany(mappedBy = "narodowosc")
    private Set<Footballer> pilkarz;

}
