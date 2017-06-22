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
public class Placer {
    /*
    *Mide los objetivos cumplidos por la ocurrencia de un evento
    * Placenteros, LigeramentePlacentero o NoPlacenteros
    */
    public String calcularPlacer(Estimulo e) throws SAXException, IOException, ParserConfigurationException {
        ObjetivosHandler oh = new ObjetivosHandler();
        ArrayList<Objetivo> objetivos = oh.obtenerObjetivos();
        ArrayList<Relacion> relacionesEstimulo = obtenerRelacionesEstimulo(e);
        double contador = 0;
 
        if (relacionesEstimulo!=null) {
            //Como afecta a esos objetivos
            for (Relacion r : relacionesEstimulo) {
                char tipo = r.getTipo(); //Indica como afecta al objetivo
                if (tipo=='S'||tipo=='I') {
                    Objetivo obj = oh.getObjetivo(r.getObjetivoAfectado()); //Trae el objetivo afectado
                    //Calcula placer
                     double indicePlacer = calcularIndice(tipo,obj.getImportancia());
                     contador += indicePlacer;
                }   
            }
        }
        String res =obPlacer(contador);
       
         return res;
    }
    
    private ArrayList<Relacion> obtenerRelacionesEstimulo(Estimulo estimulo) {
        //indicar que objetivos afecta el evento entrante.
        ArrayList<Relacion> relaciones = new ArrayList();
        Relacion r = new Relacion();
        r.setTipo('S');
        r.setObjetivoAfectado(4);
        relaciones.add(r);
        
        Relacion s = new Relacion();
        s.setTipo('I');
        s.setObjetivoAfectado(4);
        relaciones.add(s);
        return relaciones;
    }

    private double calcularIndice(char tipo, String importancia) {
        double res = 0;
        double imp=0;
        double t;
        
        if (tipo == 'S') {
            t=1;
            switch (importancia) {
                case "NoImportante":
                    //Nulo
                    res = 0;
                    break;
                case "LigeramenteImportante":
                    // "pocoPlacentero"
                    res=t*0.25;
                    break;
                case "AltamenteImportante":
                    // "muyPlacentero"
                    res=t*0.5;
                    break;
            }
        }
           if (tipo == 'I') { 
               t=-1;
            switch (importancia) {
                case "NoImportante":
                    //Nulo
                    res = 0;
                    break;
                case "LigeramenteImportante":
                    // "pocoDesagradable"
                    res = t*0.5;
                    break;
                case "AltamenteImportante":
                   //"muyDesagradable"
                    res =t*0.75 ;
                    break;
            }
        }
        return res;
    }

    private String obPlacer(double contador) {
        if (contador < 0 && contador > -0.75) {
            return "pocoDesagradable";
        }
        if (contador < -0.75) {
            return "muyDesagradable";
        }
        if (contador > 0 && contador < 0.75) {
            return "pocoPlacentero";
        }
        if (contador > 0.75) {
            return "muyPlacentero";
        }
        return "nulo";
    }

}
