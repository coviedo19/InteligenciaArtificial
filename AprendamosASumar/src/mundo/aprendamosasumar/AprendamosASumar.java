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
    InterfazAprendamosASumar interfaz;
    int resultadoImagen;
    public static ConexionDB baseDatos=new ConexionDB();
    
 
    
 public Imagen traerImagen(int nivel, String actividad, int estiloAprendizaje)throws SQLException{        
        imagen = new Imagen(null,-1);
        ResultSet resultados = null;        
            try {
            baseDatos.conectar();
            
            resultados = baseDatos.consultar("Select * From ImagenesPorActividad where codActividad="+
                    ""+nivel+""+actividad+" and codEstiloAprendizaje="+estiloAprendizaje);
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
    
    public void ensenarASumar(int nivel) throws SQLException{
        
       boolean superado= false;
        //muestra imagen actividad 01        
        practicarNivel(nivel);
        superado= this.pruebaNivel(nivel);
        if (superado == true){
            baseDatos.conectar();
            int nivelUsuario= usuario.getCODNIVEL();
            nivelUsuario =+1;
            baseDatos.ejecutar("update USUARIOS set CODNIVEL=" + nivelUsuario );        
        }
        
        else {
            JOptionPane.showMessageDialog(null, "Debes intentarlo nuevamente desde el inicio del nivel");
            ensenarASumar(nivel);
        }
        
        
        
    
    }
    
    private void decideActividad(Usuario usuario) throws SQLException{        
        if (usuario.getCODNIVEL()== 4){
            determinarNivel(usuario);
        }
        else{
            ensenarASumar(usuario.getCODNIVEL());
        }
    }
    

    private void determinarNivel(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }  
 
    
    
    public boolean pruebaNivel(int nivelUsuario){
        boolean pruebaExitosa=false;
        int respuestaUsuario;
        int respuestasCorrectas=0;
        for (int i = 0; i < 5; i++) {
            respuestaUsuario=0;//AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA;  
            if(respuestaUsuario==imagen.getResultado()){
                respuestasCorrectas++;
            }
        }
        if(respuestasCorrectas>=4){
            pruebaExitosa=true;
        }
        return pruebaExitosa;

    }
    
      
    
    public void practicarNivel (int nivel, int iResultado, int pResultado) throws SQLException{
        int correctas =0;
        if (iResultado == pResultado){
            correctas= correctas+1;
        }      
    }
    
  
    public int[] calculoEstiloAprendizaje(){
        ResultSet resultado = null;
        int [] estiloAprendizaje = new int[2];
              
        try {
            baseDatos.conectar();
            int codUsuario= usuario.getCODUSUARIO();
            
            resultado=baseDatos.consultar("Select VISUAL, AUDITIVO, KINESTECICO from CORRECTAS_X_ESTILO_APRENDIZAJE where CODUSUARIO = " +codUsuario);

            if (resultado.next() == false){
                return estiloAprendizaje;
            } 
            else{
                estiloAprendizaje[0]= resultado.getInt("VISUAL");
                estiloAprendizaje[1]= resultado.getInt("AUDITIVO");
                estiloAprendizaje[2] = resultado.getInt("KINESTECICO");           
                
               
            }
          
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Formato de Codigo de usuario invalido");
        }
        return estiloAprendizaje;
    }
    
    
    
//    public void validarRespuesta(int valor){
//        if(valor == 3){
//            JOptionPane.showMessageDialog(null, "Es tres");
//        }else{
//           JOptionPane.showMessageDialog(null, "No es tres"); 
//        }           
//    }
    
}
