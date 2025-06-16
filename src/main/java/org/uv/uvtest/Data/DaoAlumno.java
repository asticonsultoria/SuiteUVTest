
package org.uv.uvtest.Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import org.uv.uvtest.Inicio;
import org.uv.uvtest.sqlite.OnExecuteSQLite;

/**
 *
 * @author GAMR_
 */
public class DaoAlumno implements DaoGeneral<Alumno> {
    
    private final String SENTENCE_INSERT  = "INSERT INTO alumnos(dni, nombre, ap_paterno, ap_materno, puesto, folio, fecha, calificacion) VALUES(?,?,?,?,?,?,?,?)";
    private final String SENTENCE_SELECT = "SELECT * FROM alumnos;";
    private final String SENTENCE_UPDATE = "UPDATE alumnos SET calificacion = ?, normal = ?, motivacion = ?, presicion = ? WHERE dni = ? ";
    private final String SENTENCE_DELETE = "DELETE FROM alumnos where dni = ?";
    public DaoAlumno(){ }
    
    @Override
    public boolean add(Alumno pojo) {
        boolean result = true;
        OnExecuteSQLite on = new OnExecuteSQLite(pojo) {
            @Override
            public Object doOnExecute(Connection conn) throws SQLException {
                Alumno alumno = (Alumno) getParams()[0];
                PreparedStatement  stm = conn.prepareStatement(SENTENCE_INSERT);
                stm.setString(1, alumno.getDni());
                stm.setString(2, alumno.getNombre());
                stm.setString(3, alumno.getApellidoPaterno());
                stm.setString(4, alumno.getApellidoMaterno());
                stm.setString(5, alumno.getPuesto());
                stm.setString(6, alumno.getFolio());
                stm.setString(7, alumno.getFecha());
                stm.setDouble(8, alumno.getCalificacion());
                Object result = stm.executeUpdate();
                stm.close();
                return result;
            }
        };
        try{
            on.doSentence();
        }catch(Exception ex){
            Inicio.APP_LOGER.log(Level.SEVERE, ex.getMessage(), ex);
            result = false;
        }
        return result;
    }

    @Override
    public boolean delete(Alumno pojo) {
        boolean result = true;
        OnExecuteSQLite on = new OnExecuteSQLite(pojo) {
            @Override
            public Object doOnExecute(Connection conn) throws SQLException {
                Alumno alumno = (Alumno) getParams()[0];
                PreparedStatement  stm = conn.prepareStatement(SENTENCE_DELETE);
                stm.setString(1, alumno.getDni());
                Object result = stm.executeUpdate();
                stm.close();
                return result;
            }
        };
        try{
            on.doSentence();
        }catch(Exception ex){
            Inicio.APP_LOGER.log(Level.SEVERE, ex.getMessage(), ex);
            result = false;
        }
        return result;
    }

    @Override
    public boolean update(Alumno pojo) {
        boolean result = true;
        OnExecuteSQLite on = new OnExecuteSQLite(pojo) {
            @Override
            public Object doOnExecute(Connection conn) throws SQLException {
                Alumno alumno = (Alumno) getParams()[0];
                PreparedStatement  stm = conn.prepareStatement(SENTENCE_UPDATE);
                stm.setDouble(1, alumno.getCalificacion());
                stm.setDouble(2, alumno.getNormal());
                stm.setDouble(3, alumno.getMotivacion());
                stm.setDouble(4, alumno.getPresicion());
                stm.setString(5, alumno.getDni());
                Object result = stm.executeUpdate();
                stm.close();
                return result;
            }
        };
        try{
            on.doSentence();
        }catch(Exception ex){
            Inicio.APP_LOGER.log(Level.SEVERE, ex.getMessage(), ex);
            result = false;
        }
        return result;
    }

    @Override
    public Alumno read(int Cod_emp) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Alumno> readAll() {
        List<Alumno> results = new ArrayList<>();
         OnExecuteSQLite on = new OnExecuteSQLite() {
            @Override
            public Object doOnExecute(Connection conn) throws SQLException {
                Statement stm = conn.createStatement();
                ResultSet rset = stm.executeQuery(SENTENCE_SELECT);
                while (rset.next()) {
                    Alumno alumno = new Alumno();
                    alumno.setDni(rset.getString(1));
                    alumno.setNombre(rset.getString(2));
                    alumno.setApellidoPaterno(rset.getString(3));
                    alumno.setApellidoMaterno(rset.getString(4));
                    alumno.setPuesto(rset.getString(5));
                    alumno.setFolio(rset.getString(6));
                    alumno.setFecha(rset.getString(7));
                    alumno.setCalificacion(rset.getDouble(8));
                    alumno.setNormal(rset.getDouble(9));
                    alumno.setMotivacion(rset.getDouble(10));
                    alumno.setPresicion(rset.getDouble(11));
                    results.add(alumno);
                }
                rset.close();
                stm.close();
                return results;
            }
        };
        try{
            on.doSentence();
        }catch(Exception ex){
            Inicio.APP_LOGER.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return results;
    }
    
}
