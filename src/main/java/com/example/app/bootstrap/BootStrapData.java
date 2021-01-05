package com.example.app.bootstrap;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.io.File;


@Component
public class BootStrapData implements CommandLineRunner{


    @Autowired XmlToDatabase xmlToDatabase;
    @Autowired DatabaseToXml databaseToXml;
    @Autowired JsonToDatabase jsonToDatabase;
    @Autowired DatabaseToJson databaseToJson;
    File jsonInput = new File("input.json");
    File jsonOutput = new File("output.json");
    File xmlInput = new File("input.xml");
    File xmlOutput = new File("output.xml");


    @Override
    public void run(String... args) throws Exception {
        System.out.println("Zaczynamy!");
        databaseToXml.saveToXml(xmlOutput);
        databaseToJson.saveToJson(jsonOutput);
}}
