/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz.aprendamosasumar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.geom.Line2D;

import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import mundo.aprendamosasumar.AprendamosASumar;

//

/**
 * Ventana principal de la aplicación
 */
public class InterfazAprendamosASumar extends JFrame{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    private AprendamosASumar aprendamosASumar;
    
    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Panel con el encabezado
     */
    private PanelImagen panelImagen;
    
    private PanelResultado panelResultado;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor de la interfaz
     */
    public InterfazAprendamosASumar( )
    {

        aprendamosASumar = new AprendamosASumar();  
        
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
    
    
    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Inicia la aplicación
     * @param args Parámetros no utilizados
     */
    public static void main( String[] args )
    {
        InterfazAprendamosASumar interfaz = new InterfazAprendamosASumar( );
        interfaz.setVisible( true );
    }
}
