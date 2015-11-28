/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz.aprendamosasumar;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 * Panel de la imagen del título
 */
public class PanelImagen extends JPanel{
    //-----------------------------------------------------------------
    // Atributos de Interfaz
    //-----------------------------------------------------------------

    /**
     * Imagen del título
     */
    private JLabel imagen;

    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Constructor sin parámetros
     */
    public PanelImagen(String ruta)
    {
        FlowLayout layout = new FlowLayout( );
        layout.setHgap( 100 );
        layout.setVgap( 100 );
        setLayout( layout );
        
        //Carga la imagen
        ImageIcon icono = new ImageIcon( ruta );
        
        //La agrega a la etiqueta
        imagen = new JLabel( "" );
        imagen.setIcon( icono );
        add( imagen );
        
        //Color de fondo blanco
        setBackground( Color.WHITE );
        setBorder( new LineBorder( Color.GRAY ) );
    }
}
