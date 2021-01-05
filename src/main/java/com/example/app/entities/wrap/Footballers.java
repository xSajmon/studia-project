package com.example.app.entities.wrap;

import com.example.app.entities.Footballer;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "pilkarze")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class Footballers {

    @XmlElement(name = "footballer")
    private List<Footballer> myFootballers = null;




}
