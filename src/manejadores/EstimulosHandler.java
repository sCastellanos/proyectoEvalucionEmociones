/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejadores;

import clases.Estimulo;
import clases.Hecho;
import java.io.File;
import java.io.IOException;
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
public class EstimulosHandler extends DefaultHandler {

    private Estimulo estimulo; //Auxiliar 
    private Hecho hecho; //Hecho auxiliar para guardarlo en el array
    private StringBuilder buffer = new StringBuilder();//Permite leer texto simple proveninte del xml

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
       buffer.append(ch,start,length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case "consecuencia":
                estimulo.setConsecuencia(buffer.toString());
                break;
            case "sujeto":
                hecho.setSujeto(buffer.toString());
                break;
            case "predicado":
                hecho.setPredicado(buffer.toString());
                break;
            case "estimulo":
                estimulo.setHecho(hecho);

        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName) {
            case "estimulo":
                    estimulo = new Estimulo();
                    estimulo.setTipo(attributes.getValue("tipo"));
                break;
             case "hecho":
                hecho = new Hecho();
                break;
            case "sujeto":
                buffer.delete(0, buffer.length());
                break;     
            case "predicado":
                buffer.delete(0, buffer.length());
                break;                
            case "consecuencia":
               buffer.delete(0, buffer.length());
                break;
            case "id":
                buffer.delete(0, buffer.length());
                break;
        }
    }

    public Estimulo getEvento() {
       return estimulo;
    }

  
     public Estimulo obtenerEstimulo() throws SAXException, IOException, ParserConfigurationException {
        String uri = "src//estimulos//Estimulos.xml";
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance(); 
        SAXParser saxParser = saxParserFactory.newSAXParser();   //Permite leer archivo xml
        
        EstimulosHandler manejadorEstimulos = new EstimulosHandler();
        
        File file = new File(uri);
        saxParser.parse(file, manejadorEstimulos);//Lee todo el archivo xml
        
        Estimulo e = manejadorEstimulos.getEvento();
     
        return e;
    }

    public Estimulo obtenerEstimulo2() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Estimulo.class);
        //Pasar de xml a java 
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Estimulo estimulo = (Estimulo) unmarshaller.unmarshal(new File("src//estimulos//Estimulos.xml"));
        return estimulo;
    }
}
