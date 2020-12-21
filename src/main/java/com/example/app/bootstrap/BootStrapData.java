package com.example.app.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;


@Component
public class BootStrapData extends xmlParsing implements CommandLineRunner {


    @Override
    public void run(String... args) throws Exception {
        System.out.println("Zaczynamy!");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document dom = builder.parse(new File("test.xml"));
        dom.getDocumentElement().normalize();
        Element root = dom.getDocumentElement();
        System.out.println(root.getNodeName());
        NodeList nList = dom.getElementsByTagName("footballer");

        xmlToDb(nList);

            }

}
