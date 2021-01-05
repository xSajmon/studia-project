package com.example.app.bootstrap;

import com.example.app.entities.Footballer;
import com.example.app.repositories.FootballerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.time.ZonedDateTime;
import java.util.List;

@Component
public class JsonToDatabase {

    @Autowired
    FootballerRepository footballerRepository;

    public void jsonToDb(File file, ObjectMapper mapper) throws Exception{
        List<Footballer> footballers = mapper.readValue(file, mapper.getTypeFactory().constructCollectionType(List.class, Footballer.class));
        for (Footballer f : footballers) {
            f.setDataDodania(ZonedDateTime.now());
        }
        System.out.println(footballers);
        footballerRepository.saveAll(footballers);
    }
}
