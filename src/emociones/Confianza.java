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
public class Confianza {

    public Confianza() {
    }
    
        public String getReglas(Estimulo e){
                 if((e.getConsecuencia().equalsIgnoreCase("yo")||e.getConsecuencia().equalsIgnoreCase("otro"))&&
                 e.getDeseabilidad().equalsIgnoreCase("AltamenteDeseable")||e.getDeseabilidad().equalsIgnoreCase("LigeramenteDeseable")&&
                 (e.getPlacer().equalsIgnoreCase("pocoPlacentero")||e.getPlacer().equalsIgnoreCase("muyPlacentero")||e.getPlacer().equalsIgnoreCase("nulo"))&&e.getPotencialAf().equalsIgnoreCase("Si")&&(e.getNovedad().equalsIgnoreCase("poco novedoso")||e.getNovedad().equalsIgnoreCase("nada novedoso")))
         return "Confianza";
         return null;
    }
}

