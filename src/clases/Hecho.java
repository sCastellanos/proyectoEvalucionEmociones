/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Estudiante_2
 */
@XmlRootElement(name="hecho")
@XmlType(propOrder={"sujeto","predicado"})
public class Hecho {
    private String sujeto;
    private String predicado;

    public Hecho() {
    }
    

    public String getSujeto() {
        return sujeto;
    }

    public void setSujeto(String sujeto) {
        this.sujeto = sujeto;
    }


    public String getPredicado() {
        return predicado;
    }

    public void setPredicado(String predicado) {
        this.predicado = predicado;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.sujeto);
        hash = 37 * hash + Objects.hashCode(this.predicado);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Hecho other = (Hecho) obj;
        if (!Objects.equals(this.sujeto, other.sujeto)) {
            return false;
        }
        if (!Objects.equals(this.predicado, other.predicado)) {
            return false;
        }
        return true;
    }
    
    
    
    @Override
    public String toString() {
        return "Hecho{" + "sujeto=" + sujeto + ", predicado=" + predicado + '}';
    }
}
