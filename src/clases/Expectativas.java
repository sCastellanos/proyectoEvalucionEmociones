/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author sergio
 */
@XmlRootElement(name="banco_expectativas")
@XmlType(propOrder={"expectativas"})
public class Expectativas {
    
    ArrayList<Expectativa> expectativas = new ArrayList();

    public Expectativas() {
      
    }
    @XmlElementWrapper(name="expectativas")
    @XmlElement(name="expectativa")
    public ArrayList<Expectativa> getExpectativas() {
        return expectativas;
    }

    public void setExpectativas(ArrayList<Expectativa> expectativas) {
        this.expectativas = expectativas;
    }
    
    
}
