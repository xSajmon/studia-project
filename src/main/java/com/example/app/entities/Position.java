package com.example.app.entities;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pozycja")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Position  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonValue
    private String pozycja;

    @OneToMany(mappedBy = "pozycja", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Footballer> pilkarze = new HashSet<>();


}

