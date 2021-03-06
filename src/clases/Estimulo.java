/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Estudiante_2
 */
@XmlRootElement(name = "estimulo")
@XmlType(propOrder={"tipo","consecuencia", "hecho", "esExpectativa", "deseabilidad", "novedad", "placer", "oObjetivos", "potencialAf", "emocion"})
public class Estimulo {
    private String tipo;
    private String consecuencia;
    private Hecho hecho;
    private boolean esExpectativa;
    private String deseabilidad;
    private String novedad;
    private String placer;
    private String oObjetivos;
    private String potencialAf;
    private String emocion;
    

    public String getNovedad() {
        return novedad;
    }

    public void setNovedad(String novedad) {
        this.novedad = novedad;
    }

    public String getPlacer() {
        return placer;
    }

    @XmlAttribute(name="tipo")
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setPlacer(String placer) {
        this.placer = placer;
    }

    public String getoObjetivos() {
        return oObjetivos;
    }

    public void setoObjetivos(String oObjetivos) {
        this.oObjetivos = oObjetivos;
    }

    public String getPotencialAf() {
        return potencialAf;
    }

    public void setPotencialAf(String potencialAf) {
        this.potencialAf = potencialAf;
    }

    public String getEmocion() {
        return emocion;
    }

    public void setEmocion(String emocion) {
        this.emocion = emocion;
    }

    public Estimulo() {
    }

    public Hecho getHecho() {
        return hecho;
    }

    public void setHecho(Hecho hecho) {
        this.hecho = hecho;
    }

    public String getConsecuencia() {
        return consecuencia;
    }

    public void setConsecuencia(String consecuencia) {
        this.consecuencia = consecuencia;
    }

    public boolean isEsExpectativa() {
        return esExpectativa;
    }

    public void setEsExpectativa(boolean esExpectativa) {
        this.esExpectativa = esExpectativa;
    }

    public String getDeseabilidad() {
        return deseabilidad;
    }

    public void setDeseabilidad(String deseabilidad) {
        this.deseabilidad = deseabilidad;
    }

    @Override
    public String toString() {
        return "Estimulo{" + "hecho=" + hecho + ", consecuencia=" + consecuencia + ", esExpectativa=" + esExpectativa + ", deseabilidad=" + deseabilidad + ", novedad=" + novedad + ", placer=" + placer + ", oObjetivos=" + oObjetivos + ", potencialAf=" + potencialAf + ", emocion=" + emocion + '}';
    }

}
