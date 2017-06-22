/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Estudiante_2
 */
public class Accion {
    private String enunciado;
    private String id_objetivoDestino;

    public Accion() {
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String getId_objetivoDestino() {
        return id_objetivoDestino;
    }

    public void setId_objetivoDestino(String id_objetivoDestino) {
        this.id_objetivoDestino = id_objetivoDestino;
    }

    @Override
    public String toString() {
        return "Accion{" + "enunciado=" + enunciado + ", id_objetivoDestino=" + id_objetivoDestino + '}';
    }
    
       
    
    
}
