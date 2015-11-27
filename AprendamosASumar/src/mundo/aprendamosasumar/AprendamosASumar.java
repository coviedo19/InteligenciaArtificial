/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo.aprendamosasumar;

import javax.swing.JOptionPane;

/**
 *
 * @author Andrea
 */
public class AprendamosASumar {
    
    //Usuario usuario;
    //int codigoUsuario = usuario.getCODUSUARIO();
    //int nivelUsuario = usuario.getCODNIVEL();
    
    int resultadoImagen;
    
    
//    public void determinarNivel(){
//        
//        if(nivelUsuario == 0){
//            
//        }
//    }
    
    public void cambiarNivel(){
        
    }
    
    public void validarRespuesta(int valor){
        if(valor == 3){
            JOptionPane.showMessageDialog(null, "Es tres");
        }else{
           JOptionPane.showMessageDialog(null, "No es tres"); 
        }           
    }
    
}
