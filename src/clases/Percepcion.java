/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.IOException;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import manejadores.EstimulosHandler;
import org.xml.sax.SAXException;

/**
 *
 * @author Estudiante_2
 */
public class Percepcion {
EstimulosHandler eh;

    public Percepcion() {
        eh= new  EstimulosHandler();
    }

    public Estimulo obtenerEstimulo() throws SAXException, IOException, ParserConfigurationException, JAXBException {
        return eh.obtenerEstimulo2();
    }
    
    
}
