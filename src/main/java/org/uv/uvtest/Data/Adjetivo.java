/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.uvtest.Data;

/**
 *
 * @author GAMR_
 */
public class Adjetivo {
    
    private String nombreObjeto;
    private int puntuacionMore = 0;
    private int puntuacionLess = 0;
    
    public Adjetivo(String nombre){
        this.nombreObjeto = nombre;
    }

    public String getNombre(){
        return this.nombreObjeto;
    }
    
    public int getPuntuacionMore() {
        return puntuacionMore;
    }

    public int getPuntuacionLess() {
        return puntuacionLess;
    }
    
    public void addPuntuacionMore(){
        this.puntuacionMore++;
    }
    
    public void addPuntuacionLess(){
        this.puntuacionLess++;
    }
    
    public int getResultado(){
        return this.puntuacionMore - this.puntuacionLess;
    }
    
    
    
}
