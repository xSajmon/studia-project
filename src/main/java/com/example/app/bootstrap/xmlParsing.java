package com.example.app.bootstrap;

import com.example.app.entities.Footballer;
import com.example.app.entities.Nationality;
import com.example.app.entities.Position;
import com.example.app.repositories.FootballerRepository;
import com.example.app.repositories.NationalityRepository;
import com.example.app.repositories.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.time.ZonedDateTime;

public class xmlParsing {

    @Autowired
    FootballerRepository footballerRepository;
    @Autowired
    PositionRepository positionRepository;
    @Autowired
    NationalityRepository nationalityRepository;

    // Sprawdzanie czy w dokumencie xml znajduje się atrybut z tagiem odpowiadającym polu w encji
    public boolean isElementExists(String content) throws Exception {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        Document inputDoc = documentBuilderFactory.newDocumentBuilder().parse(new File("test.xml"));
        NodeList nodeList = inputDoc.getElementsByTagName(content);
        return nodeList.getLength() != 0 ? true : false;
    }

    // Wyciąganie wartości z podanego tagu
    public String getTagValue(String tag, Element element){
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node nValue = nodeList.item(0);
        if (nValue == null) return null;
        return nValue.getNodeValue();
    }

    public void xmlToDb(NodeList nList) throws Exception {
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node node = nList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;
                Footballer fut = new Footballer();

                if (isElementExists("nazwisko")) {
                    String nazwisko = getTagValue("nazwisko", eElement);
                    if (footballerRepository.existsByNazwisko(nazwisko)) {
                        fut = footballerRepository.findByNazwisko(nazwisko);
                    }
                    fut.setNazwisko(nazwisko);
                    if (isElementExists("imie")){
                        fut.setImie(getTagValue("imie", eElement));
                    }
                    if (isElementExists("pozycja")) {
                        String nazwa = getTagValue("pozycja", eElement);
                        Position pozycja = positionRepository.findByPozycja(nazwa);
                        fut.setPozycja(pozycja);
                    }
                    if (isElementExists("numer")) {
                        fut.setNumer(Integer.parseInt(getTagValue("numer", eElement)));
                    }

                    fut.setDataDodania(ZonedDateTime.now());

                    if (isElementExists("narodowosc")) {
                        String narodowosc = getTagValue("narodowosc", eElement);
                        if (!nationalityRepository.existsByNarodowosc(narodowosc)) {
                            Nationality nationality = new Nationality();
                            nationality.setNarodowosc(narodowosc);
                            nationalityRepository.save(nationality);
                        }
                        Nationality nationality = nationalityRepository.findByNarodowosc(narodowosc);
                        fut.setNarodowosc(nationality);
                    }
                }
                footballerRepository.save(fut);
            }
        }
    }}