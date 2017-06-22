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
public class Relacion {
    public static final double I = -1;  
    public static final double F = 0.25;
    public static final double N = 0.1;
    public static final double S = 1;

    private char tipo;
    private int objetivoAfectado;

    public Relacion() {
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public int getObjetivoAfectado() {
        return objetivoAfectado;
    }

    public void setObjetivoAfectado(int objetivoAfectado) {
        this.objetivoAfectado = objetivoAfectado;
    }
    
    
    
}
