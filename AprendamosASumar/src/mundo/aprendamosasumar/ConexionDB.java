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
  
    public static void main (String args []) throws SQLException{    
        DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());
        Connection conn = DriverManager.getConnection
        ("jdbc:oracle:thin:@localhost:1521:XE", "ia", "123");
        try (
            Statement stmt = conn.createStatement()){
            ResultSet rset =
            stmt.executeQuery("select BANNER from SYS.V_$VERSION");
            while (rset.next())
            System.out.println (rset.getString(1));   // Print col 1
            }          
    }    
}
