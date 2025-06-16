/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.uvtest.Data;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author GAMR_
 */
public class Preguntas {
    
    private static Preguntas ventana = null;
    
    private String[][] preguntas = new String[24][4];
    
    private ArrayList<String> dominante = new ArrayList<>();
    private ArrayList<String> influyente = new ArrayList<>();
    private ArrayList<String> estable = new ArrayList<>();
    private ArrayList<String> concienzudo = new ArrayList<>();
    
    private Adjetivo dominanteObject;
    private Adjetivo influyenteObject;
    private Adjetivo estableObject;
    private Adjetivo concienzudoObject;
    
    private List<List<Integer>> resultados = new ArrayList<List<Integer>>();
    
    
    public Preguntas(){
        this.dominanteObject = new Adjetivo("Dominante");
        this.influyenteObject = new Adjetivo("Influyente");
        this.estableObject = new Adjetivo("Estable");
        this.concienzudoObject = new Adjetivo("Concienzudo");
        
        this.llenarPreguntas();
        this.dominantePreguntas();
        this.influyentePreguntas();
        this.establePreguntas();
        this.concienzudoPreguntas();
        
    }
    
    public static Preguntas getVentana(){
        if (ventana == null) {
            ventana = new Preguntas();
        } 
        
        return ventana;
    }
    
    public String[][] getPreguntas(){
        return this.preguntas;
    }
    
    public final void llenarPreguntas(){
        String[] paso1 = {"PERSUASIVO","GENTIL","HUMILDE","ORIGINAL"};
        String[] paso2 = {"AGRESIVO","ALMA DE LA FIESTA","COMODINO","TEMEROSO"};
        String[] paso3 = {"AGRADABLE","TEMEROSO DE DIOS","TENAZ","ATRACTIVO"};
        String[] paso4 = {"CAUTELOSO","DETERMINADO","CONVINCENTE","BONACHON"};
        String[] paso5 = {"DOCIL","ATREVIDO","LEAL","ENCANTADOR"};
        String[] paso6 = {"DISPUESTO","DESEOSO","CONSECUENTE","ENTUSIASTA"};
        String[] paso7 = {"FZA DE VOLUNTAD","MENTE ABIERTA","COMPLACIENTE","ANIMOSO"};
        String[] paso8 = {"CONFIADO","SIMPATIZADOR","TOLERANTE","AFIRMATIVO"};
        String[] paso9 = {"ECUANIME","PRECISO","NERVIOSO","JOVIAL"};
        String[] paso10 = {"DISCIPLINADO","GENEROSO","ANIMOSO","PERSISTENTE"};
        String[] paso11 = {"COMPETITIVO","ALEGRE","CONSIDERADO","ARMONIOSO"};
        String[] paso12 = {"ADMIRABLE","BONDADOSO","RESIGNADO","CARACTER FIRME"};
        String[] paso13 = {"OBEDIENTE","QUISQUILLOSO","INCONQUISTABLE","JUGUETON"};
        String[] paso14 = {"RESPETUOSO","EMPRENDEDOR","OPTIMISTA","SERVICIAL" };
        String[] paso15 = {"VALIENTE", "INSPIRADOR","SUMISO","TÍMIDO"};
        String[] paso16 = {"ADAPTABLE","DISPUTADOR","INDIFERENTE","SANGRE LIVIANA"};
        String[] paso17 = {"AMIGUERO","PACIENTE","CONFIANZA EN SI MISMO","MESURADO PARA HABLAR"};
        String[] paso18 = {"CONFORME","CONFIABLE","PACIFICO","POSITIVO"};
        String[] paso19 = {"AVENTURERO","RECEPTIVO","CORDIAL","MODERADO"};
        String[] paso20 = {"INDULGENTE","ESTETA","VIGOROSO","SOCIABLE"};
        String[] paso21 = {"PARLANCHIN","CONTROLADO","CONVENCIONAL","DECISIVO"};
        String[] paso22 = {"COHIBIDO","EXACTO","FRANCO","BUEN COMPAÑERO"};
        String[] paso23 = {"DIPLOMÁTICO","AUDAZ","REFINADO","SATISFECHO"};
        String[] paso24 = {"INQUIETO","POPULAR","BUEN VECINO","DEVOTO"};
        
        this.preguntas[0] = paso1;
        this.preguntas[1] = paso2;
        this.preguntas[2] = paso3;
        this.preguntas[3] = paso4;
        this.preguntas[4] = paso5;
        this.preguntas[5] = paso6;
        this.preguntas[6] = paso7;
        this.preguntas[7] = paso8;
        this.preguntas[8] = paso9;
        this.preguntas[9] = paso10;
        this.preguntas[10] = paso11;
        this.preguntas[11] = paso12;
        this.preguntas[12] = paso13;
        this.preguntas[13] = paso14;
        this.preguntas[14] = paso15;
        this.preguntas[15] = paso16;
        this.preguntas[16] = paso17;
        this.preguntas[17] = paso18;
        this.preguntas[18] = paso19;
        this.preguntas[19] = paso20;
        this.preguntas[20] = paso21;
        this.preguntas[21] = paso22;
        this.preguntas[22] = paso23;
        this.preguntas[23] = paso24;
        
    }
    
    public final void dominantePreguntas(){
        this.dominante.add("AGRESIVO");
        this.dominante.add("TENAZ");
        this.dominante.add("DETERMINADO");
        this.dominante.add("ATREVIDO");
        this.dominante.add("AFIRMATIVO");
        this.dominante.add("PERSISTENTE");
        this.dominante.add("COMPETITIVO");
        this.dominante.add("CARACTER FIRME");
        this.dominante.add("INCONQUISTABLE");
        this.dominante.add("EMPRENDEDOR");
        this.dominante.add("VALIENTE");
        this.dominante.add("DISPUTADOR");
        this.dominante.add("CONFIANZA EN SI MISMO");
        this.dominante.add("POSITIVO");
        this.dominante.add("AVENTURERO");
        this.dominante.add("VIGOROSO");
        this.dominante.add("DECISIVO");
        this.dominante.add("FRANCO");
        this.dominante.add("AUDAZ");
        this.dominante.add("INQUIETO");
    }

    public final void influyentePreguntas(){
        this.influyente.add("PERSUASIVO");
        this.influyente.add("ALMA DE LA FIESTA");
        this.influyente.add("ATRACTIVO");
        this.influyente.add("CONVINCENTE");
        this.influyente.add("ENCANTADOR");
        this.influyente.add("ANIMOSO");
        this.influyente.add("CONFIADO");
        this.influyente.add("ADMIRABLE");
        this.influyente.add("JUGUETON");
        this.influyente.add("OPTIMISTA");
        this.influyente.add("INSPIRADOR");
        this.influyente.add("SANGRE LIVIANA");
        this.influyente.add("AMIGUERO");
        this.influyente.add("CORDIAL");
        this.influyente.add("SOCIABLE");
        this.influyente.add("PARLANCHIN");
        this.influyente.add("BUEN COMPAÑERO");
        this.influyente.add("POPULAR");     
    }
    
    public final void establePreguntas(){
        this.estable.add("GENTIL");
        this.estable.add("COMODINO");
        this.estable.add("BONACHON");
        this.estable.add("LEAL");
        this.estable.add("DISPUESTO");
        this.estable.add("COMPLACIENTE");
        this.estable.add("ECUANIME ");
        this.estable.add("GENEROSO");
        this.estable.add("CONSIDERADO");
        this.estable.add("BONDADOSO");
        this.estable.add("OBEDIENTE");
        this.estable.add("SERVICIAL");
        this.estable.add("PACIENTE");
        this.estable.add("CONFIABLE");
        this.estable.add("MODERADO");
        this.estable.add("INDULGENTE");
        this.estable.add("CONTROLADO");
        this.estable.add("SATISFECHO");
        this.estable.add("BUEN VECINO");
    }

    public final void concienzudoPreguntas(){
        this.concienzudo.add("HUMILDE");
        this.concienzudo.add("TEMEROSO DE DIOS");
        this.concienzudo.add("CAUTELOSO");
        this.concienzudo.add("CONSECUENTE");
        this.concienzudo.add("MENTE ABIERTA");
        this.concienzudo.add("PRECISO");
        this.concienzudo.add("DISCIPLINADO");
        this.concienzudo.add("RESPETUOSO");
        this.concienzudo.add("ADAPTABLE");
        this.concienzudo.add("MESURADO PARA HABLAR");
        this.concienzudo.add("PAFICICO");
        this.concienzudo.add("RECEPTIVO");
        this.concienzudo.add("EXACTO");
        this.concienzudo.add("DIPLOMÁTICO");
        this.concienzudo.add("DEVOTO");
    }

    //Metodo para buscar la clasificacion de la palabra.
    public void buscarPalabra(String palabra, String option){
        System.out.println("Buscando palabra" + palabra);
        if(this.dominante.indexOf(palabra) >= 0){
            System.out.println("Palabra pertecenece a dominante");
            if("m".equals(option)){
                this.dominanteObject.addPuntuacionMore();
            }else{
                this.dominanteObject.addPuntuacionLess();
            }
        }
        else if(this.influyente.indexOf(palabra) >= 0){
            System.out.println("Palabra pertecenece a influyente");
            if("m".equals(option)){
                this.influyenteObject.addPuntuacionMore();
            }else{
                this.influyenteObject.addPuntuacionLess();
            }
        }else if(this.estable.indexOf(palabra) >= 0){
            System.out.println("Palabra pertecenece a estable");
            if("m".equals(option)){
                this.estableObject.addPuntuacionMore();
            }else{
                this.estableObject.addPuntuacionLess();
            }
        }else if(this.concienzudo.indexOf(palabra) >= 0){
            System.out.println("Palabra pertecenece a concienzudo");
            if("m".equals(option)){
                this.concienzudoObject.addPuntuacionMore();
            }else{
                this.concienzudoObject.addPuntuacionLess();
            }
        }
    }
    
    public Adjetivo getDominante(){
        return this.dominanteObject;
    }
    
    public Adjetivo getInfluyente(){
        return this.influyenteObject;
    }
    
    public Adjetivo getEstable(){
        return this.estableObject;
    }
    
    public Adjetivo getConcienzudo(){
        return this.concienzudoObject;
    }
    
    public void obtenerResultados(){
        List<Integer> moreResultados = new ArrayList<>();
        //Resultados more
        moreResultados.add(this.dominanteObject.getPuntuacionMore());
        moreResultados.add(this.influyenteObject.getPuntuacionMore());
        moreResultados.add(this.estableObject.getPuntuacionMore());
        moreResultados.add(this.concienzudoObject.getPuntuacionMore());
        this.resultados.add(moreResultados);
        
        //Resultados less
        List<Integer> lessResultados = new ArrayList<>();
        lessResultados.add(this.dominanteObject.getPuntuacionLess());
        lessResultados.add(this.influyenteObject.getPuntuacionLess());
        lessResultados.add(this.estableObject.getPuntuacionLess());
        lessResultados.add(this.concienzudoObject.getPuntuacionLess());
        this.resultados.add(lessResultados);
        
        ///Resultados totales
        List<Integer> totalResultados = new ArrayList<>();
        totalResultados.add(this.dominanteObject.getResultado());
        totalResultados.add(this.influyenteObject.getResultado());
        totalResultados.add(this.estableObject.getResultado());
        totalResultados.add(this.concienzudoObject.getResultado());
        this.resultados.add(totalResultados);
        System.out.println(this.resultados);
    }
    
    public List<List<Integer>> getResultadosTotales(){
        return this.resultados;
    }
    
}    

