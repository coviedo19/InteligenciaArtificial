/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo.aprendamosasumar;

import java.sql.*;
import java.util.Random;
import java.util.Vector;
import javax.swing.JOptionPane;
import static mundo.aprendamosasumar.Login.baseDatos;


/**
 *
 * @author Andrea
 */
public class AprendamosASumar {
    
    Usuario usuario;   
    Imagen imagen;
    int resultadoImagen;
    
    public Imagen traerImagen(int nivel, int actividad, int estiloAprendizaje)throws SQLException{        
        imagen = new Imagen(null,-1);
        ResultSet resultados = null;        
            try {
            baseDatos.conectar();
            resultados = baseDatos.consultar("Select * From ImagenesPorActividad where codActividad="+
                    actividad+" and codEstiloAprendizaje="+estiloAprendizaje);
            if (resultados.next() == false) {
                JOptionPane.showMessageDialog(null, "No hay imagenes para este nivel");
            } else {
                int numFilas = 0;
                Vector imagenes = new Vector();
                while (resultados.next()) {
                    imagen = new Imagen(resultados.getString("rutaImagen"), resultados.getInt("resultado"));
                    imagenes.add(imagen);
                    numFilas++;
                }
                Random rnd = new Random();
                int fila = rnd.nextInt(numFilas);
                imagen = (Imagen) imagenes.get(fila);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error... traerImagen");
        } 
       
        return imagen;
    }
    
    
    public void validarRespuesta(int valor){
        if(valor == 3){
            JOptionPane.showMessageDialog(null, "Es tres");
        }else{
           JOptionPane.showMessageDialog(null, "No es tres"); 
        }           
    }
    
}
