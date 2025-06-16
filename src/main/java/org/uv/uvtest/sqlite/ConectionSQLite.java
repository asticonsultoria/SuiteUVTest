/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.uv.uvtest.sqlite;


import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import org.uv.uvtest.Inicio;

/**
 *
 * @author Asti Consultoria de Software
 */
public class ConectionSQLite {
    private final String DATABASE_NAME = "suite-uv-test.db";//"uv-alumnos.db"; 
    private final String FOLDER_APP = System.getProperty("user.home") +"\\";
    private static ConectionSQLite sqlLite;
    private Connection connection = null;
    
    public static ConectionSQLite getInstance() throws SQLException, IOException{
        if(sqlLite == null)
            sqlLite = new ConectionSQLite();
        return sqlLite;
    }
    
    private ConectionSQLite() throws SQLException, IOException{
        createFile();
        load();
        loadTable();
    }
    
    private void createFile() throws IOException{
        File file = new File(FOLDER_APP + DATABASE_NAME);
        if(!file.exists())
            file.createNewFile();
    }
    
    private void load() throws SQLException{
        try {
            String url = "jdbc:sqlite:" + FOLDER_APP + DATABASE_NAME;
            System.out.println(url);
            connection = DriverManager.getConnection("jdbc:sqlite:" + FOLDER_APP + DATABASE_NAME);
            Inicio.APP_LOGER.log(Level.INFO ,"Connection to SQLite has been established....");
        } catch (SQLException  e) {
            throw new SQLException("Error", "No fue posible establecer enlace con la base de datos.", e);
        }
    }
    
    public void closeConnection() throws SQLException{
        if (connection != null) 
            connection.close();
    }
    
    public Connection getConnection(){
        return connection;
    }
    
    
    private void loadTable() throws SQLException{
        Statement stm = connection.createStatement();
        stm.execute("CREATE TABLE IF NOT EXISTS alumnos("
                + "dni TEXT PRIMARY KEY, "
                + "nombre TEXT NOT NULL, "
                + "ap_paterno TEXT NOT NULL, "
                + "ap_materno TEXT NOT NULL, "
                + "puesto TEXT, "
                + "folio TEXT, "
                + "fecha TEXT, "
                + "calificacion REAL "
                + "); ");
        
        try{ //FIXME
            stm.execute("ALTER TABLE alumnos ADD COLUMN normal REAL;");
            stm.execute("ALTER TABLE alumnos ADD COLUMN motivacion REAL;");
            stm.execute("ALTER TABLE alumnos ADD COLUMN presicion REAL;");
        }catch(SQLException ex){
            Inicio.APP_LOGER.log(Level.SEVERE, null, ex);
        }
        stm.close();
    }
}
