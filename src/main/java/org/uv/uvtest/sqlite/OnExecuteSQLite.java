/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.uv.uvtest.sqlite;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Asti Consultoria de Software
 */
public abstract class OnExecuteSQLite <T>{
    private final Object [] params;
    
    public OnExecuteSQLite(Object... params){
        this.params = params;
    }

    public Object []  getParams() {
        return params;
    }
    
    public abstract T doOnExecute(Connection conn) throws SQLException;
    
    public T doSentence() throws SQLException, IOException{
        T result = null;
        try {
            result = doOnExecute(ConectionSQLite.getInstance().getConnection());
        }catch (SQLException ex){
             throw new SQLException(ex);
        }
        return result;
    }

}
