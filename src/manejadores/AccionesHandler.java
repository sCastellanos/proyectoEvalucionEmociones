/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejadores;

import clases.Accion;
import clases.Objetivo;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Estudiante_2
 */
public class AccionesHandler extends DefaultHandler{
    private Accion accion;
    private ArrayList<Accion> acciones;
    private StringBuilder buffer = new StringBuilder();

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
           buffer.append(ch,start,length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch(qName){
            case "acciones":
                break;
            case "accion":
                acciones.add(accion);
                break;
            case "enunciado":
                accion.setEnunciado(buffer.toString());
                break;
            case "objetivo":
                accion.setId_objetivoDestino(buffer.toString());
                break;
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch(qName){
            case "acciones":
                acciones = new ArrayList();
                buffer.delete(0, buffer.length());
                break;
            case "accion":
                buffer.delete(0, buffer.length());
                accion = new Accion();
                break;
            case "enunciado":
                buffer.delete(0, buffer.length());
                break;
            case "objetivo":
                buffer.delete(0, buffer.length());
                break;
        }
        
    }


    public ArrayList<Accion> obtenerAcciones() throws ParserConfigurationException, SAXException, IOException {
        String uri = "src//acciones//acciones.xml";
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance(); 
        SAXParser saxParser = saxParserFactory.newSAXParser();   //Permite leer archivo xml
        
        AccionesHandler manejadorAcciones = new AccionesHandler();
        
        File file = new File(uri);
        saxParser.parse(file, manejadorAcciones);//Lee todo el archivo xml
        
        ArrayList<Accion> e = manejadorAcciones.getAcciones();
     
        return e;
    }

    private ArrayList<Accion> getAcciones() {
        return acciones;
    }
    
    
    
}
