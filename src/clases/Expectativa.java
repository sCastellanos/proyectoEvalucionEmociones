/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.parsers.ParserConfigurationException;
import manejadores.ExpectativasHandler;
import org.xml.sax.SAXException;

/**
 *
 * @author Estudiante_2
 */
@XmlRootElement(name="expectativa")
@XmlType(propOrder={"hecho"})
public class Expectativa {
        Hecho hecho; 
        

    public Expectativa() {
       
    }

    public Hecho getHecho() {
        return hecho;
    }

    public void setHecho(Hecho hecho) {
        this.hecho = hecho;
    }
        
    public boolean esExpectativa(Estimulo ev) throws ParserConfigurationException, SAXException, IOException, JAXBException { 

         //Manejador de xml de expectativas
        ExpectativasHandler eh= new ExpectativasHandler();
        ArrayList<Expectativa>listaExpectativas = eh.obtenerExpectativas();
        for (Expectativa e: listaExpectativas) {
            
            if (e.getHecho().equals(ev.getHecho())) {
                  return true;
            }
        }
        return false;
    }        
}
