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
public class Miedo {

    public Miedo() {
    }
    
         public String getReglas(Estimulo e){
                 if(e.getConsecuencia().equalsIgnoreCase("yo")&&
                 e.isEsExpectativa()==false&&
                 (e.getPlacer().equalsIgnoreCase("pocoDesagradable")||e.getPlacer().equalsIgnoreCase("muyDesagradable"))&&e.getPlacer().equalsIgnoreCase("Muy novedoso"))
         return "Miedo";
         return null;
    }
 }
