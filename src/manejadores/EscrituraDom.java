/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejadores;

import clases.Estimulo;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Estudiante_2
 */
public class EscrituraDom {
    private Document document;

    public EscrituraDom() throws ParserConfigurationException {
        DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factoria.newDocumentBuilder();
        document = builder.newDocument();
    }

    public void generarDocumento(Estimulo e){
        //
         
        
        //
        Element recuerdos = document.createElement("recuerdos");
        document.appendChild(recuerdos);
        
        //Recuerdo
        Element recuerdo = document.createElement("recuerdo");
        recuerdos.appendChild(recuerdo);
        
        //Hecho
        Element hecho = document.createElement("hecho");
        Element sujeto = document.createElement("sujeto");
        sujeto.appendChild(document.createTextNode(e.getHecho().getSujeto()));
        Element predicado = document.createElement("predicado");
        predicado.appendChild(document.createTextNode(e.getHecho().getPredicado()));
        
        hecho.appendChild(sujeto);
        hecho.appendChild(predicado);
        recuerdo.appendChild(hecho);
        
        //Consecuencia
        Element consecuencia = document.createElement("consecuencia");
        consecuencia.appendChild(document.createTextNode(e.getConsecuencia()));
        recuerdo.appendChild(consecuencia);
        
        //Es expectativa?
        Element esExpectativa = document.createElement("esExpectativa");
        esExpectativa.appendChild(document.createTextNode(String.valueOf(e.isEsExpectativa())));
        recuerdo.appendChild(esExpectativa);
        
        //Deseabilidad
        Element deseabilidad = document.createElement("deseabilidad");
        deseabilidad.appendChild(document.createTextNode(e.getDeseabilidad()));
        recuerdo.appendChild(deseabilidad);
        
        //Novedad
        Element novedad = document.createElement("novedad");
        novedad.appendChild(document.createTextNode(e.getNovedad()));
        recuerdo.appendChild(novedad);
        
        //Placer
        Element placer = document.createElement("placer");
        placer.appendChild(document.createTextNode(e.getPlacer()));
        recuerdo.appendChild(placer);
        
        //Orientacion Objetivos
        Element oObjetivos = document.createElement("orientacion_objetivos");
        oObjetivos.appendChild(document.createTextNode(e.getoObjetivos()));
        recuerdo.appendChild(oObjetivos);
        
        //Orientacion Objetivos
        
        
        
        System.out.println(e);
    }   
    
    public void generarXml() throws TransformerConfigurationException, TransformerException, IOException{
        TransformerFactory factoria = TransformerFactory.newInstance();
        Transformer transformer = factoria.newTransformer();
        
        Source source = new DOMSource(document);
        File file = new File("recuerdos.xml");
        FileWriter fw = new FileWriter(file);
        PrintWriter pw = new PrintWriter(fw);
        Result result = new StreamResult(pw);
        
        transformer.transform(source, result);
        
    }
    
}
