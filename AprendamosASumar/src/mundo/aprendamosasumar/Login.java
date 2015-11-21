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

        String temp,clave;
        int codUsuario;
        temp=JOptionPane.showInputDialog("Ingrese Usuario");
        codUsuario=Integer.parseInt(temp);
        clave=JOptionPane.showInputDialog("Ingrese contraseña");
        Usuario objUsuario;
        ObjUsuario=logeo(codUsuario,clave);
    }     

    private static Usuario logeo(int codUsuario, String clave) throws SQLException {
        ResultSet resultados = null;
        Usuario usuarioActual;
        try {
         baseDatos.conectar();
        resultados=baseDatos.consultar("Select * From USUARIOS WHERE CODUSUARIO= "+usuario+"and PASSWORD="+"'"+clave+"'");
        if (resultados.next() == false){
                JOptionPane.showMessageDialog(null, "Usuario no existe o combinacion erronea");
        }else{
                String nombre=resultados.getString("NOMBREUSUARIO");
                int nivel=resultados.getInt("CODNIVEL");
                usuarioActual=new Usuario(codUsuario, nombre, nivel, clave);
                JOptionPane.showMessageDialog(null, "Bienvenido "+resultados.getString("NOMBREUSUARIO"));
        }   
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Usuario invalido");
        }
      return usuarioActual;              
    }     
}  
    
 

