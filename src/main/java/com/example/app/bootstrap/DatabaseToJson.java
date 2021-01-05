package com.example.app.bootstrap;

import com.example.app.entities.Footballer;
import com.example.app.repositories.FootballerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
public class DatabaseToJson{


    @Autowired
    private FootballerRepository footballerRepository;
    ObjectMapper mapper = new ObjectMapper();

    public void saveToJson(File file)throws  IOException{
        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        mapper.registerModule(new JavaTimeModule());
        List<Footballer> footballers = footballerRepository.findAll();
        mapper.writerWithDefaultPrettyPrinter().withRootName("footballers").writeValue(file, footballers);
        }

}
