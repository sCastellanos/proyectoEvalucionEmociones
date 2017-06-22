/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emociones;

import clases.Estimulo;

/**
 *
 * @author Estudiante_2
 */
public class Sorpresa {

    public Sorpresa() {
    }
    
     public String getReglas(Estimulo e){
                 if(
                         e.getConsecuencia().equalsIgnoreCase("yo")&&
                         e.getDeseabilidad().equalsIgnoreCase("Neutral")&&
                         e.isEsExpectativa()==true&&
                         (e.getNovedad().equalsIgnoreCase("muy novedoso"))
                 )
         return "Sorpresa";
         return null;
    }
}
