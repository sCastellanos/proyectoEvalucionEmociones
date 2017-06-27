/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejadores;

import clases.Expectativa;
import clases.Expectativas;
import clases.Hecho;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
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
public class ExpectativasHandler extends DefaultHandler{
     private Hecho hecho; //Hecho auxiliar para guardarlo en el array
     private Expectativa expectativa;
     private ArrayList<Expectativa> expectativas = new ArrayList();
    private StringBuilder buffer = new StringBuilder();//Permite leer texto simple proveninte del xml

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
         buffer.append(ch,start,length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
                switch(qName){
            case "sujeto":
                hecho.setSujeto(buffer.toString());
                break;
            case "predicado":
                hecho.setPredicado(buffer.toString());
                break;
            case "hecho":
                expectativa.setHecho(hecho);
                break;
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName) {
            case "expectativas":
                break;
            case "expectativa":
                
                break;
            case "hecho":
                expectativa = new Expectativa();
                expectativas.add(expectativa);
                hecho=new Hecho();
                break;
            case "sujeto":
            case "predicado":
                buffer.delete(0, buffer.length());
                break;
        }
    }

    public ArrayList<Expectativa> getExpectativas() {
        return expectativas;
    }
    
      public static ArrayList<Expectativa> leerExpectativasXML() throws ParserConfigurationException, SAXException, IOException{
        String uri = "src//expectativas//expectativas.xml";
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance(); 
        SAXParser saxParser = saxParserFactory.newSAXParser();   //Permite leer archivo xml
        
        ExpectativasHandler manejadorExpectativas = new ExpectativasHandler();
        
        File expectativas = new File(uri);
        saxParser.parse(expectativas, manejadorExpectativas);//Lee todo el archivo xml
        
        ArrayList<Expectativa> exp = manejadorExpectativas.getExpectativas();
              
        return exp;
    }

    public ArrayList<Expectativa> obtenerExpectativas() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Expectativas.class);
        //Pasar de xml a java 
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Expectativas exp = (Expectativas) unmarshaller.unmarshal(new File("src//expectativas//expectativas.xml"));
        
        return exp.getExpectativas();
    }
}
