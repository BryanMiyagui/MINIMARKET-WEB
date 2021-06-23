/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.company.auxiliar;

import java.sql.*;

public class ConnectionJDBC 
{
    public static Connection MySQL() throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.jdbc.Driver");
       // String url="jdbc:mysql://localhost:3306/bd_minimarket";
        String url="jdbc:mysql://172.96.143.27:3306/db_minimarket";
        
   
        
        return DriverManager.getConnection(url,"root","actelperusac");
    }
}
