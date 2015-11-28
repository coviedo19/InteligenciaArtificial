/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz.aprendamosasumar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.geom.Line2D;
import java.sql.*;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import mundo.aprendamosasumar.AprendamosASumar;

import mundo.aprendamosasumar.*;

import mundo.aprendamosasumar.ConexionDB;
import mundo.aprendamosasumar.Imagen;
import static mundo.aprendamosasumar.Login.baseDatos;
import mundo.aprendamosasumar.Usuario;


//

/**
 * Ventana principal de la aplicación
 */
public class InterfazAprendamosASumar extends JFrame{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    public static ConexionDB baseDatos=new ConexionDB();
    private AprendamosASumar aprendamosASumar;
    private Imagen imagen;
    private Usuario usuario;
  
    
    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Panel con el encabezado
     */
    private PanelImagen panelImagen;    
    public static PanelLogin panelLogin;
    private PanelResultado panelResultado;    
    private PanelLogin panellogin;
    private mundo.aprendamosasumar.Login inicioSesion;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor de la interfaz
     */
    public InterfazAprendamosASumar( )
    {
  

        aprendamosASumar = new AprendamosASumar();  

    /**
     *
     */
    
                
        //Crea la interfaz
        setTitle( "Aprendam" );
        getContentPane( ).setLayout( new BorderLayout( ) );
        setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        setResizable(false);
        //setLocationRelativeTo(this);
        
        
        
        panelImagen = new PanelImagen("src/imagen/"+traerImagen().getRuta());
        getContentPane( ).add( panelImagen, BorderLayout.NORTH );
        
        panelResultado = new PanelResultado(this);
        getContentPane().add(panelResultado, BorderLayout.SOUTH);

        pack( );
        repintar( );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    public Imagen traerImagen(){
        try {
            imagen = aprendamosASumar.traerImagen(4, 401, 1);
        } catch (SQLException ex) {
            Logger.getLogger(InterfazAprendamosASumar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return imagen;
    }
    
    
    public void validarRespuesta(int valorIngresado){        
        aprendamosASumar.validarRespuesta(valorIngresado);
    }
    
    /**
     * Repinta el triángulo y los valores
     *  
     */
    public void repintar( )
    {
        panelImagen.repaint( );       
    }
    

    

    public void enseñarASumar(int nivel){
        
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
        }
        
        
        
    
    }
    
    public void practicarNivel (int nivel){
        int correctas =0;
        while (correctas<=8){
        // Metodo para pintar imagen
            int iResultado = imagen.getResultado();           
            int pResultado = panelResultado.resultado();
        
            if (iResultado == pResultado){
                correctas= correctas+1;
            }
        }
    }
    
    public boolean pruebaNivel(int nivel){
        boolean superado= false;
        
        return superado;
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
    

    public void logeo(String u, String c) throws SQLException{
//        boolean usuarioExiste = false;
//        panelLogin=new PanelLogin(this);
//        panelLogin.setVisible(true);
        usuario = inicioSesion.logeo(u, c);
        if (usuario!=null){
            panelLogin.dispose();
            InterfazAprendamosASumar interfaz = new InterfazAprendamosASumar( );
            interfaz.setVisible( true );
            //usuarioExiste=true;
            //decideActividad(usuario);
        }
    }
    

    public void iniciarSesion(){
        panelLogin=new PanelLogin(this);
        panelLogin.setVisible(true);
    }


    
            
    

    
    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Inicia la aplicación
     * @param args Parámetros no utilizados
     */
    public static void main( String[] args ){
         InterfazAprendamosASumar i = new InterfazAprendamosASumar();
         i.iniciarSesion();
        
       // InterfazAprendamosASumar interfaz = new InterfazAprendamosASumar( );
        //interfaz.setVisible( true );
    }

    
    private void decideActividad(Usuario usuario) {
        int nivel = usuario.getCODNIVEL();
        if (nivel== 4){
            determinarNivel(usuario);
        }
        else{
            enseñarASumar(nivel);
        }
    }
    

    private void determinarNivel(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }  
 
    
    
    public boolean pruebaNivel2(int nivelUsuario){
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
}
