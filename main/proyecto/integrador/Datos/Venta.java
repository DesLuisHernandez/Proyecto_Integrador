/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.proyecto.integrador.Datos;

/**
 *
 * @author genny
 */

public class Venta {
    private double precioTotal;
    private int numCuotas;
    private double intereses;
    private String cedCliente;
    private String cedAsesor;
    private String matriculaApto;    

    public Venta() {
    }

    public Venta(double precioTotal, int numCuotas, double intereses, String cedCliente, String cedAsesor, String matriculaApto) {
        this.precioTotal = precioTotal;
        this.numCuotas = numCuotas;
        this.intereses = intereses;
        this.cedCliente = cedCliente;
        this.cedAsesor = cedAsesor;
        this.matriculaApto = matriculaApto;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public int getNumCuotas() {
        return numCuotas;
    }

    public void setNumCuotas(int numCuotas) {
        this.numCuotas = numCuotas;
    }

    public double getIntereses() {
        return intereses;
    }

    public void setIntereses(double intereses) {
        this.intereses = intereses;
    }

    public String getCedCliente() {
        return cedCliente;
    }

    public void setCedCliente(String cedCliente) {
        this.cedCliente = cedCliente;
    }

    public String getCedAsesor() {
        return cedAsesor;
    }

    public void setCedAsesor(String cedAsesor) {
        this.cedAsesor = cedAsesor;
    }

    public String getMatriculaApto() {
        return matriculaApto;
    }

    public void setMatriculaApto(String matriculaApto) {
        this.matriculaApto = matriculaApto;
    }

    @Override
    public String toString() {
        return "Venta{" + "precioTotal=" + precioTotal + ", numCuotas=" + numCuotas + ", intereses=" + intereses + ", cedCliente=" + cedCliente + ", cedAsesor=" + cedAsesor + ", matriculaApto=" + matriculaApto + '}';
    }
}
