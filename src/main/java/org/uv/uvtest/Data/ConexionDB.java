/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.uvtest.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GAMR_
 */
public class ConexionDB {
    
    private static ConexionDB ventana = null;
    private Connection conn;
    
    private ConexionDB(){
        try{
            Class.forName("org.firebirdsql.jdbc.FBDriver");
            System.out.println("Registrando Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("No se registro el driver");
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public static ConexionDB getVentana(){
        if(ventana == null){
            ventana = new ConexionDB();
        }
        return ventana;
    }
    
    public void setConexion() throws SQLException{
        String url = "jdbc:firebirdsql:localhost/3050:D:\\GAMR_\\Documents\\Trabajo\\ExamenPsicometrico\\db\\alumnosdb.fdb";
        this.conn = DriverManager.getConnection(url, "sysdba", "0828");
        
    }
    
    public Connection getConexion(){
        return conn;
    }
}
