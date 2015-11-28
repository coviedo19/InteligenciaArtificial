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

import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import mundo.aprendamosasumar.AprendamosASumar;
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
    boolean usuarioExiste=false;
    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Panel con el encabezado
     */
    private PanelImagen panelImagen;
    private Imagen imagen;
    public static PanelLogin panelLogin;
    private PanelResultado panelResultado;
    private PanelLogin panellogin;
    private mundo.aprendamosasumar.Login inicioSesion;
    private mundo.aprendamosasumar.Usuario usuario=null;
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
        setTitle( "Triángulo" );
        getContentPane( ).setLayout( new BorderLayout( ) );
        setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        setResizable(false);
        setLocationRelativeTo(this);
        
        
        
        panelImagen = new PanelImagen( );
        getContentPane( ).add( panelImagen, BorderLayout.NORTH );
        
        panelResultado = new PanelResultado(this);
        getContentPane().add(panelResultado, BorderLayout.SOUTH);

        pack( );
        repintar( );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

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
    
    public void calculoEstiloAprendizaje(){
        ResultSet resultados = null;
        
        try {
            baseDatos.conectar();
            resultados=baseDatos.consultar("Select * From USUARIOS WHERE CODUSUARIO= "+codUsuario+" and PASSWORD="+"'"+clave+"'");
            if (resultados.next() == false){
            } 
          
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Formato de Codigo de usuario invalido");
        }
    }
    
    public void logeo(String u, String c) throws SQLException{
        usuarioExiste=false;
        usuario=null;
        usuario=inicioSesion.logeo(u, c);
        if (usuario!=null){
            panelLogin.dispose();
            InterfazAprendamosASumar interfaz = new InterfazAprendamosASumar( );
            interfaz.setVisible( true );
            usuarioExiste=true;
            decideActividad(usuario);
        }
    }
    

    
            
    
    
    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Inicia la aplicación
     * @param args Parámetros no utilizados
     */
    public static void main( String[] args )
    {
        panelLogin=new PanelLogin();
        panelLogin.setVisible(true);
               
        
       // InterfazAprendamosASumar interfaz = new InterfazAprendamosASumar( );
        //interfaz.setVisible( true );
    }

    private void decideActividad(Usuario usuario) {
        
        if (usuario.getCODNIVEL()== 4){
         determinarNivel(usuario);
     }
     else{
         enseñarASumar();
     }
    }

    private void determinarNivel(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void enseñarASumar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
