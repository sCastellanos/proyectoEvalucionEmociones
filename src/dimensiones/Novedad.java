/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dimensiones;

import clases.Estimulo;
import clases.Recuerdo;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Estudiante_2
 */
public class Novedad {

    public Novedad() {
    }

    private boolean estaMemoria(Estimulo ev) throws ParserConfigurationException, SAXException, IOException {
        Recuerdo recuerdo = new Recuerdo();
        ArrayList<Recuerdo> listaRecuerdos = Recuerdo.leerRecuerdosXML();
        for (Recuerdo r : listaRecuerdos) {
            if (ev.getHecho().equals(r.getHecho())) {
                return true;
            }
        }
        return false;
    }

    private String detSimilitud(Estimulo ev) {
        return "nada";
    }
// regresa un arreglo, si el recuerdo

    private String detFamiliaridad(Estimulo ev) throws ParserConfigurationException, SAXException, IOException {
        int sumFam = 0;
        Recuerdo recuerdo = new Recuerdo();
        ArrayList<Recuerdo> listaRecuerdos = Recuerdo.leerRecuerdosXML();
        for (Recuerdo r : listaRecuerdos) {
            if (r.getHecho().equals(ev.getHecho())) {
                sumFam = r.getFamiliaridad() + 1;
            } else {
                sumFam = r.getFamiliaridad();
            }
        }
        if (sumFam == 0) {
            return "ninguna";
        } else if (sumFam > 0 && sumFam < 10) {
            return "baja";
        } else {
            return "alta";
        }
    }

    private String reglasNovedad(boolean estaMemoria, String similitud, String familiaridad) {
        if (estaMemoria&&familiaridad.equalsIgnoreCase("baja")) {
            return "muy novedoso";
        }else if(estaMemoria&&familiaridad.equalsIgnoreCase("alta")){
            return "poco novedoso";
        }else if(estaMemoria==false&&similitud.equalsIgnoreCase("nada")&&familiaridad.equalsIgnoreCase("ninguna")){
            return "muy novedoso";
        }else if(estaMemoria==false&&similitud.equalsIgnoreCase("poco")&&familiaridad.equalsIgnoreCase("ninguna")){
            return "muy novedoso";
        }else if(estaMemoria==false&&similitud.equalsIgnoreCase("poco")&&familiaridad.equalsIgnoreCase("baja")){
            return "poco novedoso";
        }else if(estaMemoria==false&&similitud.equalsIgnoreCase("poco")&&familiaridad.equalsIgnoreCase("alta")){
            return "nada novedoso";
        }else if(estaMemoria==false&&similitud.equalsIgnoreCase("muy")&&familiaridad.equalsIgnoreCase("ninguna")){
            return "muy novedoso";
        }else if(estaMemoria==false&&similitud.equalsIgnoreCase("muy")&&familiaridad.equalsIgnoreCase("baja")){
            return "poco novedoso";
        }else if(estaMemoria==false&&similitud.equalsIgnoreCase("muy")&&familiaridad.equalsIgnoreCase("alta")){
            return "nada novedoso";
        }
        return "poco novedoso";
    }

    public String calcularNovedad(Estimulo ev) throws ParserConfigurationException, SAXException, IOException {
        String similitud;
        //Busca  hechos iguales en memoria
        boolean estaMemoria = estaMemoria(ev);
        if (estaMemoria) {
            similitud = "igual";
        } else {
            //Determina la similitud de un evento
         similitud = detSimilitud(ev);
        }
        //Familiaridad numero de veces que se experimenta el mismo evento
        String familiaridad = detFamiliaridad(ev);
        
        return reglasNovedad(estaMemoria, similitud, familiaridad);
    }

}
