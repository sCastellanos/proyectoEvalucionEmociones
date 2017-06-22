/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejadores;

import clases.Objetivo;
import clases.Relacion;
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
public class ObjetivosHandler extends DefaultHandler{
   private Objetivo objetivo;
   private ArrayList<Objetivo> objetivos;
    
   private Relacion relacion;
   private ArrayList<Relacion> relaciones;
   
    
    private StringBuilder buffer = new StringBuilder();

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        buffer.append(ch,start,length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch(qName){
            case "objetivos":  
                break;
            case "objetivo":
                objetivos.add(objetivo);
                break;
            case "enunciado":
                objetivo.setEnunciado(buffer.toString());
                break;
            case "importancia":
                objetivo.setImportancia(buffer.toString());
                break;
            case "relaciones_salida":
                objetivo.setRelaciones_salida(relaciones);
                break;
            case "relacion":
                relacion.setObjetivoAfectado(Integer.parseInt(buffer.toString()));
                relaciones.add(relacion);
                break;
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                switch(qName){
            case "objetivos":
                buffer.delete(0, buffer.length());
                objetivos = new ArrayList();
                break;
            case "objetivo":
                buffer.delete(0, buffer.length());
                objetivo = new Objetivo();
                objetivo.setId(Integer.parseInt(attributes.getValue("id")));
                break;
            case "enunciado":
                buffer.delete(0, buffer.length());
                break;
            case "importancia":
                buffer.delete(0, buffer.length());
                break;
            case "relaciones_salida":
                buffer.delete(0, buffer.length());
                relaciones = new ArrayList<Relacion>();
                break;
            case "relacion":
                buffer.delete(0, buffer.length());
                relacion = new Relacion();
                relacion.setTipo(attributes.getValue("tipo").toCharArray()[0]);
                break;
        }
    }

    public ArrayList<Objetivo> getObjetivos() {
        return objetivos;
    }
    
    public ArrayList<Objetivo> obtenerObjetivos() throws SAXException, IOException, ParserConfigurationException {
        String uri = "src//objetivos//objetivosXML.xml";
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance(); 
        SAXParser saxParser = saxParserFactory.newSAXParser();   //Permite leer archivo xml
        
        ObjetivosHandler manejadorObjetivos = new ObjetivosHandler();
        
        File file = new File(uri);
        saxParser.parse(file, manejadorObjetivos);//Lee todo el archivo xml
        
        ArrayList<Objetivo> e = manejadorObjetivos.getObjetivos();
     
        return e;
    }

    public Objetivo getObjetivo(int objetivoAfectado) throws ParserConfigurationException, SAXException, IOException {
        String uri = "src//objetivos//objetivosXML.xml";
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance(); 
        SAXParser saxParser = saxParserFactory.newSAXParser();   //Permite leer archivo xml
        
        ObjetivosHandler manejadorObjetivos = new ObjetivosHandler();
        
        File file = new File(uri);
        saxParser.parse(file, manejadorObjetivos);//Lee todo el archivo xml
        
        Objetivo o = null;
        ArrayList<Objetivo> lo = manejadorObjetivos.getObjetivos();
        for (Objetivo obj : lo) {
            if (obj.getId()==objetivoAfectado) {
                o=obj;
            }
        }
     
        return o; 
    }
}
