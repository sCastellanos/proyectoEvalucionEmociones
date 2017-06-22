/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import emociones.Alegria;
import emociones.Anticipacion;
import emociones.Confianza;
import emociones.Enojo;
import emociones.Miedo;
import emociones.Rechazo;
import emociones.Sorpresa;
import emociones.Tristeza;

/**
 *
 * @author Estudiante_2
 */
public class CalculoEmociones {

    Alegria alegria;
    Anticipacion anticipacion;
    Confianza confianza;
    Enojo enojo;
    Miedo miedo;
    Rechazo rechazo;
    Sorpresa sorpresa;
    Tristeza tristeza;

    public CalculoEmociones() {
        alegria = new Alegria();
        anticipacion = new Anticipacion();
        confianza = new Confianza();
        enojo = new Enojo();
        miedo = new Miedo();
        rechazo = new Rechazo();
        sorpresa = new Sorpresa();
        tristeza = new Tristeza();
    }

    public String calcularEmocion(Estimulo estimulo) {
       String emocion = "";
        emocion = alegria.getReglas(estimulo);
        emocion = anticipacion.getReglas(estimulo);
        emocion = confianza.getReglas(estimulo);
        emocion = enojo.getReglas(estimulo);
        emocion = miedo.getReglas(estimulo);
        emocion = rechazo.getReglas(estimulo);
        emocion = sorpresa.getReglas(estimulo);
        emocion = tristeza.getReglas(estimulo);
        return emocion;
    }

}
