/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz.aprendamosasumar;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * Panel de manejo de extensiones
 * @author Pablo Barvo
 */
public class PanelResultado extends JPanel implements ActionListener
{

    //-----------------------------------------------------------------
    // Constantes
    //-----------------------------------------------------------------

    /**
     * Comando Opción 1
     */
    private static final String ENVIAR  = "ENVIAR";


    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación
     */
    private InterfazAprendamosASumar padre;   
    

    //-----------------------------------------------------------------
    // Atributos de interfaz
    //-----------------------------------------------------------------

    /**
     * Botón
     */
    private JButton btnEnviar;
    
    private JTextField txtResultado;


    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Constructor del panel
     * @param elPadre Ventana principal
     */
    public PanelResultado( InterfazAprendamosASumar elPadre )
    {
        padre = elPadre;

        setBorder( new TitledBorder( "Resultado" ) );
        setLayout( new GridLayout( 1, 2 ) );
        
        txtResultado = new JTextField();
        add(txtResultado);

        //Botón enviar
        btnEnviar = new JButton( "Enviar" );
        btnEnviar.setActionCommand( ENVIAR );
        btnEnviar.addActionListener( this );
        add( btnEnviar );
        
        

    }

    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------

    /**
     * Manejo de los eventos de los botones
     * @param e Acción que generó el evento.
     */
    public void actionPerformed( ActionEvent e )
    {
        if( ENVIAR.equals( e.getActionCommand( ) ) )
        {
            padre.validarRespuesta(Integer.parseInt(txtResultado.getText()));
        }  
    }

}
