/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_experto;

import clases.Estimulo;
import emociones.Alegria;
import emociones.Tristeza;

/**
 *
 * @author Estudiante_2
 */
public class BaseConocimiento {
    Alegria alegria;
    Tristeza tristeza;

    public BaseConocimiento() {
        alegria=new Alegria();
        tristeza=new Tristeza();
    }
    
    public String reglasEmociones(Estimulo e){
         //Reglas para producir emociones
         String a = alegria.getReglas(e);
         String t = tristeza.getReglas(e);
         
         return null;
         
    }       
}
