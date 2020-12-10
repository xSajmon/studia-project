package com.example.app;

import com.example.app.entities.Footballer;
import com.example.app.entities.Nationality;
import com.example.app.entities.Position;
import com.example.app.repositories.FootballerRepository;
import com.example.app.repositories.NationalityRepository;
import com.example.app.repositories.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;


@SpringBootApplication
public class Main {


    public static void main(String[] args)  {
        SpringApplication.run(Main.class, args);
    }
        }







