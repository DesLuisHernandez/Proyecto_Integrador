/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.proyecto.integrador.Datos;

/**
 *
 * @author genny
 */
public class Apartamentos {
    private int numApto;
    private String tipoLocal;
    private String tipoApto;
    private String tipoGaraje;
    private double area;
    private String idTorre;

    public Apartamentos(int numApto, String tipoLocal, String tipoApto, String tipoGaraje, double area, String idTorre) {
        this.numApto = numApto;
        this.tipoLocal = tipoLocal;
        this.tipoApto = tipoApto;
        this.tipoGaraje = tipoGaraje;
        this.area = area;
        this.idTorre = idTorre;
    }

    public Apartamentos() {
    }

    public int getNumApto() {
        return numApto;
    }

    public void setNumApto(int numApto) {
        this.numApto = numApto;
    }

    public String getTipoLocal() {
        return tipoLocal;
    }

    public void setTipoLocal(String tipoLocal) {
        this.tipoLocal = tipoLocal;
    }

    public String getTipoApto() {
        return tipoApto;
    }

    public void setTipoApto(String tipoApto) {
        this.tipoApto = tipoApto;
    }

    public String getTipoGaraje() {
        return tipoGaraje;
    }

    public void setTipoGaraje(String tipoGaraje) {
        this.tipoGaraje = tipoGaraje;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getIdTorre() {
        return idTorre;
    }

    public void setIdTorre(String idTorre) {
        this.idTorre = idTorre;
    }

   
}
