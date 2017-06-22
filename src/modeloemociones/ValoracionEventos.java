/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloemociones;

import clases.CalculoEmociones;
import clases.Estimulo;
import clases.Expectativa;
import clases.Percepcion;
import dimensiones.Deseabilidad;
import dimensiones.Novedad;
import dimensiones.OrientacionObj;
import dimensiones.Placer;
import dimensiones.PotencialAf;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import manejadores.EscrituraDom;
import org.xml.sax.SAXException;

/**
 *
 * @author Estudiante_2
 */
public class ValoracionEventos {

    /**
     * @param args the command line arguments
     * @throws javax.xml.parsers.ParserConfigurationException
     * @throws org.xml.sax.SAXException
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException {
        CalculoEmociones ce = new CalculoEmociones();
        Estimulo estimulo = new Estimulo();
        Expectativa expectativa = new Expectativa();
        EscrituraDom eDOM = new EscrituraDom();
   
         Percepcion percepcion = new Percepcion();
       

        /***********************Variables************************/
        Novedad nov = new Novedad();
        Placer pla = new Placer();
        OrientacionObj orientacion = new OrientacionObj();
        PotencialAf potencialAf = new PotencialAf();
        Deseabilidad deseabilidad = new Deseabilidad();
        
        
        estimulo = percepcion.obtenerEstimulo();

        /****************************************** ¿Es expectativa?*********************************************/
        estimulo.setEsExpectativa(expectativa.esExpectativa(estimulo));

        /***************************************** Medir la deseabilidad*****************************************/
        estimulo.setDeseabilidad(deseabilidad.calcularDeseabilidad(estimulo));

        /*******************************se evaluan las 4 variables basicas para eventos**********************/
        estimulo.setNovedad(nov.calcularNovedad(estimulo));                             System.out.println("Novedad: "+estimulo.getNovedad());
        estimulo.setPlacer(pla.calcularPlacer(estimulo));                                      System.out.println("Placer: "+estimulo.getPlacer());
        estimulo.setoObjetivos(orientacion.calcularOrientacionObj(estimulo));    System.out.println("Orietacion: "+estimulo.getoObjetivos());
        estimulo.setPotencialAf(potencialAf.calcularPotencial(estimulo));             System.out.println("Potencial: "+estimulo.getPotencialAf());

        /********************************************Emocion resultante*******************************************/
        String emocion = ce.calcularEmocion(estimulo);
        
        //guardar en memoria el estimulo.
        eDOM.generarDocumento(estimulo);
        eDOM.generarXml();
        System.out.println(emocion);
    }

}
