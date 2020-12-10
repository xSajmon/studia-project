package com.example.app.entities;



import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "klub")
@Data
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nazwa;
    @Column(name = "data_zal",length = 4)
    private Long dataZalozenia;

    @OneToOne
    private Coach trener;

    @OneToMany(mappedBy = "klubPilkarza")
    private Set<Footballer> pilkarze = new HashSet<>();

    @OneToOne
    private Stadium stadion;




}
