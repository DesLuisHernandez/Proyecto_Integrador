/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.proyecto.integrador.Datos;

import java.util.Date;

/**
 *
 * @author genny
 */

public class Venta {
    private double matricula;
    private double precio_Total;
    private double cantidad_Cuotas;
    private double intereses;
    private Date fecha_esctritura_venta;
    private Date fecha_venta;
    private double valorSubsidio;
    private String id_Apto;  
    private String cedula_Cliente;
    private String id_Usuario;

    public Venta() {
    }

    public Venta(double matricula, double precio_Total, int cantidad_Cuotas, double intereses, Date fecha_esctritura_venta, Date fecha_venta, double valorSubsidio, String id_Apto, String cedula_Cliente, String id_Usuario) {
        this.matricula = matricula;
        this.precio_Total = precio_Total;
        this.cantidad_Cuotas = cantidad_Cuotas;
        this.intereses = intereses;
        this.fecha_esctritura_venta = fecha_esctritura_venta;
        this.fecha_venta = fecha_venta;
        this.valorSubsidio = valorSubsidio;
        this.id_Apto = id_Apto;
        this.cedula_Cliente = cedula_Cliente;
        this.id_Usuario = id_Usuario;
    }

    public double getMatricula() {
        return matricula;
    }

    public void setMatricula(double matricula) {
        this.matricula = matricula;
    }

    public double getPrecio_Total() {
        return precio_Total;
    }

    public void setPrecio_Total(double precio_Total) {
        this.precio_Total = precio_Total;
    }

    public double getCantidad_Cuotas() {
        return cantidad_Cuotas;
    }

    public void setCantidad_Cuotas(int cantidad_Cuotas) {
        this.cantidad_Cuotas = cantidad_Cuotas;
    }

    public double getIntereses() {
        return intereses;
    }

    public void setIntereses(double intereses) {
        this.intereses = intereses;
    }

    public Date getFecha_esctritura_venta() {
        return fecha_esctritura_venta;
    }

    public void setFecha_esctritura_venta(Date fecha_esctritura_venta) {
        this.fecha_esctritura_venta = fecha_esctritura_venta;
    }

    public Date getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(Date fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public double getValorSubsidio() {
        return valorSubsidio;
    }

    public void setValorSubsidio(double valorSubsidio) {
        this.valorSubsidio = valorSubsidio;
    }

    public String getId_Apto() {
        return id_Apto;
    }

    public void setId_Apto(String id_Apto) {
        this.id_Apto = id_Apto;
    }

    public String getCedula_Cliente() {
        return cedula_Cliente;
    }

    public void setCedula_Cliente(String cedula_Cliente) {
        this.cedula_Cliente = cedula_Cliente;
    }

    public String getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(String id_Usuario) {
        this.id_Usuario = id_Usuario;
    }

    @Override
    public String toString() {
        return "Venta{" + "matricula=" + matricula + ", precio_Total=" + precio_Total + ", cantidad_Cuotas=" + cantidad_Cuotas + ", intereses=" + intereses + ", fecha_esctritura_venta=" + fecha_esctritura_venta + ", fecha_venta=" + fecha_venta + ", valorSubsidio=" + valorSubsidio + ", id_Apto=" + id_Apto + ", cedula_Cliente=" + cedula_Cliente + ", id_Usuario=" + id_Usuario + '}';
    }
      
}
