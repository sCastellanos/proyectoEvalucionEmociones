/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dimensiones;

import clases.Accion;
import clases.Estimulo;
import clases.Relacion;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import manejadores.AccionesHandler;
import org.xml.sax.SAXException;

/**
 *
 * @author Estudiante_2
 */
public class PotencialAf {
    AccionesHandler ah = new AccionesHandler();
    ArrayList<Accion> listaAcciones =new ArrayList();
    
    public String calcularPotencial(Estimulo estimulo) throws ParserConfigurationException, SAXException, IOException {
        //Obtiene la lista de acciones
        listaAcciones = ah.obtenerAcciones();
        ArrayList<Relacion> relacionesEstimulo = obtenerRelacionesEstimulo(estimulo);
        for (Relacion relacion : relacionesEstimulo) {
            for (Accion accion : listaAcciones) {
                if (relacion.getObjetivoAfectado()==Integer.parseInt(accion.getId_objetivoDestino())) {
                     return "si";
                }
            }
        }
        return "no";
    }
    
    //Establece la relacion del estimulo con el objetivo
    private ArrayList<Relacion> obtenerRelacionesEstimulo(Estimulo estimulo) {
        //indicar que objetivos afecta el evento entrante.
        ArrayList<Relacion> relaciones = new ArrayList();
        Relacion r = new Relacion();
        r.setTipo('I');
        r.setObjetivoAfectado(4);
        relaciones.add(r);
        return relaciones;
    }
    
}
