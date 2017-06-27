/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejadores;

import clases.Accion;
import clases.Hecho;
import clases.Objetivo;
import clases.Recuerdo;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Estudiante_2
 */
public class RecuerdosHandler extends DefaultHandler {

    private StringBuilder buffer = new StringBuilder();
    private Hecho hecho;
    private String emocion;
    private Accion accion;
    private Recuerdo recuerdo;
    private Objetivo objetivo;

    private ArrayList<Accion> acciones = new ArrayList();
    private ArrayList<Objetivo> objetivos = new ArrayList();
    private ArrayList<Recuerdo> recuerdos = new ArrayList();

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        buffer.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case "memoria":
                recuerdos.add(recuerdo);
                break;
            case "recuerdo":
                recuerdo.setAcciones(acciones);
                recuerdo.setEmocion(emocion);
                recuerdo.setHecho(hecho);
                recuerdo.setObjetivos_afectados(objetivos);
                break;
            case "hecho":
                recuerdo.setHecho(hecho);
                break;
            case "sujeto":
                hecho.setSujeto(buffer.toString());
                break;
            case "predicado":
                hecho.setPredicado(buffer.toString());
                break;
            case "emocion":
                emocion = buffer.toString();
                break;
            case "acciones":
                acciones.add(accion);
                break;
            case "accion":
                recuerdo.setAcciones(acciones);
                break;
            case "objetivos_afectados":
                recuerdo.setObjetivos_afectados(objetivos);
                break;
            case "objetivo":
                objetivos.add(objetivo);
                break;
            case "familiaridad":
                recuerdo.setFamiliaridad(Integer.parseInt(buffer.toString()));
                break;
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName) {
            case "memoria":
                buffer.delete(0, buffer.length());
                break;
            case "recuerdo":
                buffer.delete(0, buffer.length());
                recuerdo = new Recuerdo();
                break;
            case "hecho":
                buffer.delete(0, buffer.length());
                hecho = new Hecho();
                break;
            case "sujeto":
                buffer.delete(0, buffer.length());
                break;
            case "predicado":
                buffer.delete(0, buffer.length());
                break;
            case "emocion":
                buffer.delete(0, buffer.length());
                break;
            case "acciones":
                buffer.delete(0, buffer.length());
                break;
            case "accion":
                buffer.delete(0, buffer.length());
                accion = new Accion();
                break;
            case "objetivos_afectados":
                buffer.delete(0, buffer.length());
                break;
            case "objetivo":
                buffer.delete(0, buffer.length());
                objetivo = new Objetivo();
                break;
            case "familiaridad":
                buffer.delete(0, buffer.length());
                break;
        }
    }

    public ArrayList<Recuerdo> getRecuerdos() {
        return recuerdos;
    }

}
