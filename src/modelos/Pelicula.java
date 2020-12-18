/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author Lants
 */
public class Pelicula {
    
    public int code;
    public String title;
    public int cost;
    public int numSocio;
    public boolean bitMuerto;

    public Pelicula(int code, String title, int cost, int numSocio, boolean bitMuerto) {
        this.code = code;
        this.title = title;
        this.cost = cost;
        this.numSocio = numSocio;
        this.bitMuerto = bitMuerto;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getNumSocio() {
        return numSocio;
    }

    public void setNumSocio(int numSocio) {
        this.numSocio = numSocio;
    }

    public boolean isBitMuerto() {
        return bitMuerto;
    }

    public void setBitMuerto(boolean bitMuerto) {
        this.bitMuerto = bitMuerto;
    }
    
    public void printPelicula() {
        System.out.println("La pelicula de codigo " + code + " "
                + "titulada "
                + title + " " + "cuesta " + cost + " y su bitMuerto esta en " + bitMuerto);
        System.out.println();
    }
}
