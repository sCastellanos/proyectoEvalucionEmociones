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
public class Tristeza {

    public Tristeza() {
    }
 
    public String getReglas(Estimulo e){
                 if((e.getConsecuencia().equalsIgnoreCase("yo")||e.getConsecuencia().equalsIgnoreCase("otro"))&&
                 e.getDeseabilidad().equalsIgnoreCase("AltamenteDeseable")||e.getDeseabilidad().equalsIgnoreCase("altamenteIndeseable")&&
                 (e.getPlacer().equalsIgnoreCase("pocoDesagradable")||e.getPlacer().equalsIgnoreCase("muyDesagradable"))&&
                 e.getoObjetivos().equalsIgnoreCase("negativo"))
         return "tristeza";
         return null;
    }
}
