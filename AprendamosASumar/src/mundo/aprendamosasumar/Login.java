/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo.aprendamosasumar;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.*;


/**
 *
 * @author Andrea
 **/
public class Login {
public static ConexionDB baseDatos=new ConexionDB();


    public static void main(String[] args) throws SQLException {
        String usuario,clave;
        usuario=JOptionPane.showInputDialog("Ingrese Usuario");
        clave=JOptionPane.showInputDialog("Ingrese contraseña");
        //Usuario objUsuario=new Usuario();
        logeo(usuario,clave);
    }     

    private static void logeo(String usuario, String clave) throws SQLException {
        ResultSet resultados = null;
        baseDatos.conectar();

        resultados=baseDatos.consultar("Select * From USUARIOS WHERE NOMBREUSUARIO= "+usuario+"and password="+clave);
//        while (resultados.next()) {
//            System.out.println(""+resultados.getBigDecimal("CODUSUARIO")+"       "+resultados.getString("NOMBREUSUARIO"));
//        }
        if (resultados != null){
            JOptionPane.showMessageDialog(null, "Bienvenido "+ usuario);

        resultados=baseDatos.consultar("Select  From USUARIOS WHERE NOMBREUSUARIO="+usuario+"and password="+clave);
        if (resultados!= null){
            JOptionPane.showMessageDialog(null, "Bienvenido"+usuario);

        }       
        else{ 
            JOptionPane.showMessageDialog(null, "Usuario no existe o combinacion erronea");
        }
    }
 }
}  
    
 

