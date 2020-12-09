package com.example.app.entities;



import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "klub")
@Data
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;




}
