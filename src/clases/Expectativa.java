/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import manejadores.ExpectativasHandler;
import org.xml.sax.SAXException;

/**
 *
 * @author Estudiante_2
 */
public class Expectativa {
        Hecho hecho; 
        ExpectativasHandler eh;

    public Expectativa() {
        //Manejador de xml de expectativas
       eh = new ExpectativasHandler();
    }

    public Hecho getHecho() {
        return hecho;
    }

    public void setHecho(Hecho hecho) {
        this.hecho = hecho;
    }
        
    public boolean esExpectativa(Estimulo ev) throws ParserConfigurationException, SAXException, IOException { 
        ArrayList<Expectativa>listaExpectativas = eh.leerExpectativasXML();
        for (Expectativa e: listaExpectativas) {
            if (e.getHecho().getSujeto().equals(ev.getHecho().getSujeto())&&
                e.getHecho().getCopula().equals(ev.getHecho().getCopula())&&
                e.getHecho().getPredicado().equals(ev.getHecho().getPredicado())) {
                  return true;
            }
        }
        return false;
    }        
}
