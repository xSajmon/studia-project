package com.example.app.bootstrap;

import com.example.app.entities.Club;
import com.example.app.entities.Footballer;
import com.example.app.entities.Nationality;
import com.example.app.entities.Position;
import com.example.app.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class BootStrapData implements CommandLineRunner {

    private final ClubRepository clubRepository;
    private final CoachRepository coachRepository;
    private final FootballerRepository footballerRepository;
    private final NationalityRepository nationalityRepository;
    private final PositionRepository positionRepository;
    private final StadiumRepository stadiumRepository;

    public BootStrapData(ClubRepository clubRepository,
                         CoachRepository coachRepository,
                         FootballerRepository footballerRepository,
                         NationalityRepository nationalityRepository,
                         PositionRepository positionRepository,
                         StadiumRepository stadiumRepository) {
        this.clubRepository = clubRepository;
        this.coachRepository = coachRepository;
        this.footballerRepository = footballerRepository;
        this.nationalityRepository = nationalityRepository;
        this.positionRepository = positionRepository;
        this.stadiumRepository = stadiumRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Zaczynamy!");

    }
}

