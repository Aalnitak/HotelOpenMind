/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author duoc
 */
public class Conexion {

    private static Connection conexion;

    private Conexion() {
        
    }
// commit comentario en conexion
    public static Connection getConnection() {
        
        String url = "jdbc:mysql://localhost:3307/hotel?autoReconnect=true&useSSL=false";
        String user = "root";
        String pass = "system";
        System.out.println("Conectando..");  

        try {
            conexion = DriverManager.getConnection(url, user, pass);
            System.out.println("Conexion Exitosa");

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }

        return conexion;

    }
    
    
    public static void closeConection(){
        try{
            if (conexion !=null){
                conexion.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
