package com.example.app.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class BootStrapData extends Database2XML implements CommandLineRunner {



    @Override
    public void run(String... args) throws Exception {
        System.out.println("Zaczynamy!");

        dBToXml();




}}
