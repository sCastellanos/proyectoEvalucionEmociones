/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author sergio
 */
@XmlRootElement(name="banco_acciones")
@XmlType(propOrder={"acciones"})
public class Acciones {
    ArrayList<Accion> acciones = new ArrayList();

    public Acciones() {
    }

    @XmlElementWrapper(name="acciones")
    @XmlElement(name="accion")
    public ArrayList<Accion> getAcciones() {
        return acciones;
    }

    public void setAcciones(ArrayList<Accion> acciones) {
        this.acciones = acciones;
    }
    
    
    
    
}
