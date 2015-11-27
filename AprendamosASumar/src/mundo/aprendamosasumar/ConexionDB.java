
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
public class ConexionDB {
    
    private Connection conexion;
    
    public Connection getConexion(){
        return conexion;
    }
    
    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
    
    public ConexionDB conectar() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            String BaseDeDatos = "jdbc:oracle:thin:@localhost:1521:XE";

            conexion = DriverManager.getConnection(BaseDeDatos, "ia","123");
            if (conexion != null) {
                System.out.println("Conexion exitosa!");
            } else {
                System.out.println("Conexion fallida!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }        return this;
    }
    
    
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
    
    
    
    
    
    /*
    public static void main(String[] args) {
        ConexionDB baseDatos = new ConexionDB().conectar();        
        if (baseDatos.ejecutar("INSERT INTO NIVEL(CODNIVEL,DESCRIPCION) VALUES(2,'NIVEL 2')")) {
            System.out.println("Ejecucion correcta!");
        } else {
            System.out.println("Ocurrió un problema al ejecutar!");
        }        
        ResultSet resultados = baseDatos.consultar("Select * From USUARIOS where CODUSUARIO=1 AND PASSWORD='23'");        
        if (resultados != null) {
            try {
                System.out.println("CODIGO NIVEL       DESCRIPCION");
                System.out.println("--------------------------------");
                while (resultados.next()) {
                    //System.out.println(""+resultados.getBigDecimal("CODNIVEL")+"       "+resultados.getString("DESCRIPCION"));
                    System.out.println(""+resultados.getBigDecimal("CODUSUARIO"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }*/

}