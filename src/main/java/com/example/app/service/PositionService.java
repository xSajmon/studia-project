package com.example.app.service;

import com.example.app.entities.Position;
import com.example.app.repositories.PositionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PositionService {

    @Autowired
    private PositionRepository positionRepository;

    public List<Position> getPositions(){
        return positionRepository.findAll();
    }


}
