/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dimensiones;

import clases.Estimulo;
import clases.Relacion;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Estudiante_2
 */
public class Deseabilidad {
String impacto;
String Importancia;
OrientacionObj oo = new OrientacionObj();
    public String calcularDeseabilidad(Estimulo ev) throws ParserConfigurationException, SAXException, IOException {
        impacto = oo.calcularOrientacionObj(ev);
        if (impacto.equalsIgnoreCase("positivo")) {
             return "AltamenteDeseable";
        }else if (impacto.equalsIgnoreCase("negativo")) {
            return "altamenteIndeseable";
        }
       return "neutral";
    }
   
}
