/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;

/**
 *
 * @author Estudiante_2
 */
public class Objetivo {
    private int id;
    private String enunciado;
    private String importancia;
    private ArrayList<Relacion> relaciones_salida;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String getImportancia() {
        return importancia;
    }

    public void setImportancia(String importancia) {
        this.importancia = importancia;
    }

    public ArrayList<Relacion> getRelaciones_salida() {
        return relaciones_salida;
    }

    public void setRelaciones_salida(ArrayList<Relacion> relaciones_salida) {
        this.relaciones_salida = relaciones_salida;
    }

    public Objetivo() {
    }

    @Override
    public String toString() {
        return "Objetivo{" + "id=" + id + ", enunciado=" + enunciado + ", importancia=" + importancia + ", relaciones_salida=" + relaciones_salida + '}';
    }
    
    
}
