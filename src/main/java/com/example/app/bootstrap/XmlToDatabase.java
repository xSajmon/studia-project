package com.example.app.bootstrap;

import com.example.app.entities.Footballer;
import com.example.app.entities.wrap.Footballers;
import com.example.app.repositories.FootballerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.time.ZonedDateTime;

@Component
public class XmlToDatabase {
    @Autowired
    FootballerRepository footballerRepository;

    public void xmlDb(File file) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Footballers.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Footballers footballers = (Footballers) jaxbUnmarshaller.unmarshal(file);
        for (Footballer f : footballers.getMyFootballers()) {
            f.setDataDodania(ZonedDateTime.now());
            footballerRepository.save(f);
        }
    }
}