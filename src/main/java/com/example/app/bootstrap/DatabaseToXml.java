package com.example.app.bootstrap;

import com.example.app.entities.Footballer;
import com.example.app.repositories.FootballerRepository;
import com.example.app.repositories.NationalityRepository;
import com.example.app.repositories.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.time.format.DateTimeFormatter;

@Component
public class DatabaseToXml {

    @Autowired
    FootballerRepository footballerRepository;
    @Autowired
    NationalityRepository nationalityRepository;
    @Autowired
    PositionRepository positionRepository;

    public void saveToXml(File file) throws Exception {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document doc = documentBuilder.newDocument();
        Element root = doc.createElement("pilkarze");
        doc.appendChild(root);

        for(Footballer footballer : footballerRepository.findAll()){
            Element fut  = doc.createElement("footballer");
            root.appendChild(fut);
            Element imie = doc.createElement("imie");
            Element nazwisko = doc.createElement("nazwisko");
            Element narodowosc = doc.createElement("narodowosc");
            Element pozycja = doc.createElement("pozycja");
            Element numer = doc.createElement("numer");
            Element dataDodania = doc.createElement("dataDodania");
            fut.appendChild(imie);
            fut.appendChild(nazwisko);
            fut.appendChild(narodowosc);
            fut.appendChild(pozycja);
            fut.appendChild(numer);
            fut.appendChild(dataDodania);
            imie.setTextContent(footballer.getImie());
            nazwisko.setTextContent(footballer.getNazwisko());
            narodowosc.setTextContent(footballer.getNarodowosc().getNarodowosc());
            pozycja.setTextContent(footballer.getPozycja().getPozycja());
            numer.setTextContent(String.valueOf(footballer.getNumer()));
            dataDodania.setTextContent(footballer.getDataDodania().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

    }
    TransformerFactory transformerFactory = TransformerFactory.newInstance();
    Transformer transformer = transformerFactory.newTransformer();
    DOMSource source = new DOMSource(doc);
    StreamResult result = new StreamResult(file);
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        transformer.transform(source, result);

    }
}
