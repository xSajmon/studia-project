package com.example.app.bootstrap;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class BootStrapData extends Database2XML implements CommandLineRunner {

    @Autowired DatabaseToJson databaseToJson;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Zaczynamy!");
        databaseToJson.saveToJson();




}}
