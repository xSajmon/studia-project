package com.example.app.entities;

import lombok.AllArgsConstructor;
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

    private String narodowosc;

    @OneToMany(mappedBy = "narodowosc")
    private Set<Footballer> pilkarz;

}
