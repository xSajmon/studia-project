package com.example.app.service;

import com.example.app.entities.Footballer;
import com.example.app.repositories.FootballerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FootballerService {

    @Autowired
    private FootballerRepository footballerRepository;


    public List<Footballer> getFootballers(){
        return footballerRepository.findAll();
    }
}
