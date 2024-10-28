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
    private int idApartamento;
    private int idTorre;
    private int matricula;
    private int numeroApto;
    private double valorApto;
    private String tipoApto;
    private int area;
    private String asesorVenta;
    private String MatriculaVenta;

    public int getIdApartamento() {
        return idApartamento;
    }

    public void setIdApartamento(int idApartamento) {
        this.idApartamento = idApartamento;
    }

    public int getIdTorre() {
        return idTorre;
    }

    public void setIdTorre(int idTorre) {
        this.idTorre = idTorre;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public int getNumeroApto() {
        return numeroApto;
    }

    public void setNumeroApto(int numeroApto) {
        this.numeroApto = numeroApto;
    }

    public double getValorApto() {
        return valorApto;
    }

    public void setValorApto(double valorApto) {
        this.valorApto = valorApto;
    }

    public String getTipoApto() {
        return tipoApto;
    }

    public void setTipoApto(String tipoApto) {
        this.tipoApto = tipoApto;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getAsesorVenta() {
        return asesorVenta;
    }

    public void setAsesorVenta(String asesorVenta) {
        this.asesorVenta = asesorVenta;
    }

    public String getMatriculaVenta() {
        return MatriculaVenta;
    }

    public void setMatriculaVenta(String MatriculaVenta) {
        this.MatriculaVenta = MatriculaVenta;
    }

    @Override
    public String toString() {
        return "Apartamentos{" + "idApartamento=" + idApartamento + ", idTorre=" + idTorre + ", matricula=" + matricula + ", numeroApto=" + numeroApto + ", valorApto=" + valorApto + ", tipoApto=" + tipoApto + ", area=" + area + ", asesorVenta=" + asesorVenta + ", MatriculaVenta=" + MatriculaVenta + '}';
    }
}
