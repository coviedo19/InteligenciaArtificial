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


  /*  public static void main(String[] args) throws SQLException {

        String codUsuario,clave;
        codUsuario=JOptionPane.showInputDialog("Ingrese Codigo de Usuario");
        clave=JOptionPane.showInputDialog("Ingrese Contraseña");
        Usuario objUsuario=null;
        objUsuario=logeo(codUsuario,clave);
        JOptionPane.showMessageDialog(null, objUsuario.getCODUSUARIO()+objUsuario.getNOMBREUSUARIO()+objUsuario.getCODNIVEL()+objUsuario.getPASWORD());
    }   */  

    private static Usuario logeo(String codUsuario, String clave) throws SQLException {
        ResultSet resultados = null;
        Usuario usuarioActual=null;
        try {
         baseDatos.conectar();
        resultados=baseDatos.consultar("Select * From USUARIOS WHERE CODUSUARIO= "+codUsuario+"and PASSWORD="+"'"+clave+"'");
        if (resultados.next() == false){
                JOptionPane.showMessageDialog(null, "Usuario no existe o combinacion erronea");
        }else{
                String nombre=resultados.getString("NOMBREUSUARIO");
                int nivel=resultados.getInt("CODNIVEL");
                int intcodusuario=Integer.parseInt(codUsuario);
                usuarioActual=new Usuario(intcodusuario, nombre, nivel, clave);
                JOptionPane.showMessageDialog(null, "Bienvenido "+resultados.getString("NOMBREUSUARIO"));
        }   
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Usuario invalido");
        }
      return usuarioActual;              
    }     
}  
    
 

