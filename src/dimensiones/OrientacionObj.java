/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dimensiones;

import clases.Estimulo;
import clases.Objetivo;
import clases.Relacion;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import manejadores.ObjetivosHandler;
import org.xml.sax.SAXException;

/**
 *
 * @author Estudiante_2
 */
public class OrientacionObj {
    ObjetivosHandler oh = new ObjetivosHandler();

    public String calcularOrientacionObj(Estimulo estimulo) throws ParserConfigurationException, SAXException, IOException {
        //A que objetivos afecta?
        ArrayList<Relacion> relacionesEstimulo = obtenerRelacionesEstimulo(estimulo);
      
        if (relacionesEstimulo!=null) {
            
            //Como afecta a esos objetivos
            for (Relacion relacion : relacionesEstimulo) {
                char tipo = relacion.getTipo(); //Indica como afecta al objetivo
                Objetivo obj = oh.getObjetivo(relacion.getObjetivoAfectado()); //Trae el objetivo afectado
                double indiceOrientacion = calcularIndice(tipo, obj.getImportancia());

                ArrayList<Relacion> relacionesObjetivo = obj.getRelaciones_salida();
                for (Relacion rel : relacionesObjetivo) {
                    tipo = rel.getTipo();
                    obj = oh.getObjetivo(rel.getObjetivoAfectado());
                    indiceOrientacion = indiceOrientacion + calcularIndice(tipo, obj.getImportancia());
                }
                if (indiceOrientacion<0) {
                                      return "negativo";
                }else{
                return "positivo";}
            }
        }
        return "nulo";
    }

    /*
    se genera una ista de los objetivos que impacta el estimulo (trabajo futuro se deba hacer automatico)
    */
    private ArrayList<Relacion> obtenerRelacionesEstimulo(Estimulo estimulo) {
        //indicar que objetivos afecta el evento entrante
        ArrayList<Relacion> relaciones = new ArrayList();
        Relacion r = new Relacion();
        r.setTipo('I');
        r.setObjetivoAfectado(4);
        relaciones.add(r);
        return relaciones;
    }

    private double calcularIndice(char tipo, String importancia) {
        double i=0;
        double t=0;
        switch (tipo) {
            case 'I':
                t = -1;
                break;
            case 'S':
                t = 1;
                break;
            case 'F':
                t = 0.25;
                break;
            case 'N':
                t = 0.1;
                break;
        }
            switch(importancia){
            case "NoImportante":
                i=0.25;
                break;
            case "LigeramenteImportante":
                i=0.5;
                break;
            case "AltamenteImportante":
                i=0.75;
                break;
        }        
            double res = t*i;
       return res;
    }

}
