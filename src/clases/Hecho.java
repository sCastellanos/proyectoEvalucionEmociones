/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.Objects;

/**
 *
 * @author Estudiante_2
 */
public class Hecho {
    private String sujeto;
    private String copula;
    private String predicado;

    public Hecho() {
    }
    

    public String getSujeto() {
        return sujeto;
    }

    public void setSujeto(String sujeto) {
        this.sujeto = sujeto;
    }

    public String getCopula() {
        return copula;
    }

    public void setCopula(String copula) {
        this.copula = copula;
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
        hash = 37 * hash + Objects.hashCode(this.copula);
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
        if (!Objects.equals(this.copula, other.copula)) {
            return false;
        }
        if (!Objects.equals(this.predicado, other.predicado)) {
            return false;
        }
        return true;
    }
    
    
    
    @Override
    public String toString() {
        return "Hecho{" + "sujeto=" + sujeto + ", copula=" + copula + ", predicado=" + predicado + '}';
    }
}
