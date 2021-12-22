package com.mycompany.myapp.testingspeech;

/**
 * Created by Paul on 5/10/2018.
 */
public class Detailse {
    private String genname, unita, unitb, titlea, titleb, inputa , inputb;
    private int imagea, imageb;
    private int which;
    public Detailse(){

    }
    public Detailse(String genname, int imagea, int imageb, String titlea, String titleb, int which, String inputa,String inputb, String unita,String unitb ){
        this.genname = genname;
        this.imagea = imagea;
        this.imageb = imageb;
        this.titlea = titlea;
        this.titleb = titleb;
        this.which = which;
        this.inputa = inputa;
        this.inputb = inputb;
        this.unita = unita;
        this.unitb = unitb;

    }

    public void setGenname(String genname) {
        this.genname = genname;
    }

    public void setImagea(int imagea) {
        this.imagea = imagea;
    }

    public void setImageb(int imageb) {
        this.imageb = imageb;
    }

    public void setInputa(String inputa) {
        this.inputa = inputa;
    }

    public void setInputb(String inputb) {
        this.inputb = inputb;
    }

    public void setTitlea(String titlea) {
        this.titlea = titlea;
    }

    public void setTitleb(String titleb) {
        this.titleb = titleb;
    }

    public void setUnita(String unita) {
        this.unita = unita;
    }

    public void setUnitb(String unitb) {
        this.unitb = unitb;
    }

    public void setWhich(int which) {
        this.which = which;
    }

    public int getImagea() {
        return imagea;
    }

    public int getImageb() {
        return imageb;
    }

    public int getWhich() {
        return which;
    }

    public String getGenname() {
        return genname;
    }

    public String getInputa() {
        return inputa;
    }

    public String getInputb() {
        return inputb;
    }

    public String getTitlea() {
        return titlea;
    }

    public String getTitleb() {
        return titleb;
    }

    public String getUnita() {
        return unita;
    }

    public String getUnitb() {
        return unitb;
    }
}
