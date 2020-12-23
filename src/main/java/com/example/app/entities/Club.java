package com.example.app.entities;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "klub")
@Data
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonValue
    private String nazwa;
    @Column(name = "data_zal",length = 4)
    private Long dataZalozenia;

    @OneToOne
    private Coach trener;

    @JsonIgnore
    @OneToMany(mappedBy = "klubPilkarza")
    private Set<Footballer> pilkarze = new HashSet<>();

    @OneToOne
    private Stadium stadion;




}
