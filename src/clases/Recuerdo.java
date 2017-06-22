/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import manejadores.RecuerdosHandler;
import org.xml.sax.SAXException;

/**
 *
 * @author Estudiante_2
 */
public class Recuerdo {
    private Hecho hecho;
    private String emocion;
    private ArrayList<Accion> acciones;
    private ArrayList<Objetivo> objetivos_afectados;
    private int familiaridad;

    public Recuerdo() {
    }

    public Hecho getHecho() {
        return hecho;
    }

    public int getFamiliaridad() {
        return familiaridad;
    }

    public void setFamiliaridad(int familiaridad) {
        this.familiaridad = familiaridad;
    }

    public void setHecho(Hecho hecho) {
        this.hecho = hecho;
    }

    public String getEmocion() {
        return emocion;
    }

    public void setEmocion(String emocion) {
        this.emocion = emocion;
    }

    public ArrayList<Accion> getAcciones() {
        return acciones;
    }

    public void setAcciones(ArrayList<Accion> acciones) {
        this.acciones = acciones;
    }

    public ArrayList<Objetivo> getObjetivos_afectados() {
        return objetivos_afectados;
    }

    public void setObjetivos_afectados(ArrayList<Objetivo> objetivos_afectados) {
        this.objetivos_afectados = objetivos_afectados;
    }

    @Override
    public String toString() {
        return "Recuerdo{" + "hecho=" + hecho + ", emocion=" + emocion + ", acciones=" + acciones + ", objetivos_afectados=" + objetivos_afectados + ", familiaridad=" + familiaridad + '}';
    }
    
    
    
    public static ArrayList<Recuerdo> leerRecuerdosXML() throws ParserConfigurationException, SAXException, IOException{
        String uri = "src//memoria//Memoria.xml";
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance(); 
        SAXParser saxParser = saxParserFactory.newSAXParser();   //Permite leer archivo xml
        
        RecuerdosHandler manejadorRecuerdos = new RecuerdosHandler();
        
        File file = new File(uri);
        saxParser.parse(file, manejadorRecuerdos);//Lee todo el archivo xml
        
        ArrayList<Recuerdo> recuerdos = manejadorRecuerdos.getRecuerdos();
        return recuerdos;
    }
    
}
