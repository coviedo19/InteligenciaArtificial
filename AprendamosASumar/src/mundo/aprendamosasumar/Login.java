/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo.aprendamosasumar;

import java.sql.*;



/**
 *
 * @author Andrea
 */
public class Login {
       
    /*
    * Ejecuta sentencias en la base de datos
    */
    public boolean ejecutar(String sql) {
        try{
            Statement sentencia;
            sentencia = getConexion().createStatement(ResultSet.TYPE_FORWARD_ONLY,  ResultSet.CONCUR_READ_ONLY);
            sentencia.executeUpdate(sql);
            getConexion().commit();
            sentencia.close();
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    
    /*
    * Realiza consultas en la base de datos
    */
    public ResultSet consultar(String sql) {
        ResultSet resultado = null;
        try {
            Statement sentencia;
            sentencia = getConexion().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            resultado = sentencia.executeQuery(sql);
            getConexion().commit();
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }        
        return resultado;
    }
        
}
