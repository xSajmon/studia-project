package com.example.app.bootstrap;

import com.example.app.entities.Footballer;
import com.example.app.service.FootballerService;
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

    ObjectMapper objectMapper = new ObjectMapper();


    @Autowired
    private FootballerService footballerService;
    File file = new File("json.json");
    public void saveToJson()throws  IOException{
        objectMapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        objectMapper.registerModule(new JavaTimeModule());
        List<Footballer> footballers = footballerService.getFootballers();
        objectMapper.writerWithDefaultPrettyPrinter().withRootName("footballers").writeValue(file, footballers);
        }

}
