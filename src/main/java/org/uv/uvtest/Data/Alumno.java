package org.uv.uvtest.Data;

import java.util.UUID;

/**
 *
 * @author GAMR_
 */
public class Alumno {
    
    private String nombre;
    private String apellidos;
    private String puesto;
    private String folio;
    private String fecha;
    private double calificacion;
    private String dni;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private double normal;
    private double motivacion;
    private double presicion;

    public Alumno(String nombre, String apellidoPaterno, String apellidoMaterno,
                  String puesto, String folio, String fecha)
    {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.puesto = puesto;
        this.folio = folio;
        this.fecha = fecha;
        this.dni = UUID.randomUUID().toString();
    }
    
    public Alumno(){
    
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public double getNormal() {
        return normal;
    }

    public void setNormal(double normal) {
        this.normal = normal;
    }

    public double getMotivacion() {
        return motivacion;
    }

    public void setMotivacion(double motivacion) {
        this.motivacion = motivacion;
    }

    public double getPresicion() {
        return presicion;
    }

    public void setPresicion(double presicion) {
        this.presicion = presicion;
    }
    
    
    
}
