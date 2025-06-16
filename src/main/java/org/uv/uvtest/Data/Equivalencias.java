/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.uvtest.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author GAMR_
 */
public class Equivalencias {
    
   
    private List<Integer> dmList = null;
    
    private List<Integer> imList = null;
    
    private List<Integer> smList = null;
    
    private List<Integer> cmList = null;
    
    private List<Integer> dlList = null;
    
    private List<Integer> ilList = null;
    
    private List<Integer> slList = null;
    
    private List<Integer> clList = null;
    
    private List<Integer> dtList = null;
    
    private List<Integer> itList = null;
    
    private List<Integer> stList = null;
    
    private List<Integer> ctList = null;
    
    private int dtRango = 21;
    private int itRango = 19;
    private int stRango = 19;
    private int ctRango = 16;
    
    public Equivalencias(){
         this.dmList = Arrays.asList(1,5,10,20,30,40,50,60,65,75,84,87,90,93,95,97,97,98,98,98,99);
         this.imList = Arrays.asList(4,10,25,40,55,70,82,90,95,96,97,97,97,97,97,97,97,99);
         this.smList = Arrays.asList(5,10,16,30,40,55,63,75,84,90,95,96,97,97,97,97,98,98,98,99);
         this.cmList = Arrays.asList(1,5,16,30,55,70,84,93,95,97,97,97,98,98,98,99);
         
         this.dlList = Arrays.asList(99,95,87,80,65,55,50,35,30,20,18,15,10,6,5,4,3,2,2,2,2,1);
         this.slList = Arrays.asList(99,97,95,87,80,65,55,35,28,18,10,5,4,3,3,3,2,2,2,1);
         this.ilList = Arrays.asList(99,95,87,75,55,40,25,16,10,5,4,4,3,3,3,2,2,2,2,1);
         this.clList = Arrays.asList(99,97,95,90,84,70,55,40,38,23,10,5,4,3,2,2,1);
         
         this.dtList = Arrays.asList(1,2,2,2,2,2,2,2,4,5,5,9,13,15,16,20,25,29,35,40,45,50,55,60,65,67,70,
        75,80,84,85,90,91,94,95,96,97,97,98,98,98,99);
         this.itList = Arrays.asList(1,2,2,2,2,2,2,2,2,3,4,5,6,10,16,20,29,35,45,55,60,70,75,85,90,95,96,
        97,97,98,98,98,98,98,98,98,99);
         this.stList = Arrays.asList(1,2,2,2,2,2,2,3,4,5,8,10,15,20,25,30,35,40,50,57,60,70,75,80,84,87,91,94,
        96,97,97,98,98,98,98,98,98,98,99);
         this.ctList = Arrays.asList(1,2,2,2,2,3,4,6,9,13,20,25,35,40,55,60,70,75,84,90,95,96,97,97,98,98,98,
        98,98,98,98,99);
         
         
    };

    public List<Integer> getDmList() {
        return dmList;
    }

    public List<Integer> getImList() {
        return imList;
    }

    public List<Integer> getSmList() {
        return smList;
    }

    public List<Integer> getCmList() {
        return cmList;
    }

    public List<Integer> getDlList() {
        return dlList;
    }

    public List<Integer> getIlList() {
        return ilList;
    }

    public List<Integer> getSlList() {
        return slList;
    }

    public List<Integer> getClList() {
        return clList;
    }

    public List<Integer> getDtList() {
        return dtList;
    }

    public List<Integer> getItList() {
        return itList;
    }

    public List<Integer> getStList() {
        return stList;
    }

    public List<Integer> getCtList() {
        return ctList;
    }

    public int getDtRango() {
        return dtRango;
    }

    public int getItRango() {
        return itRango;
    }

    public int getStRango() {
        return stRango;
    }

    public int getCtRango() {
        return ctRango;
    }

   
    
    
}
