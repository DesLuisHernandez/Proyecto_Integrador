/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.proyecto.integrador.Datos;

import java.util.Date;

/**
 *
 * @author Alejandra
 */
public class Pago {
    private Number valorPago;
    private Date fechaPago;
    private Number cedula_cliente; 
    private Number matricula_venta; 
    private String id_usuario; 

    public Pago() {
    }

    public Pago(Number valorPago, Date fechaPago, Number cedula_cliente, Number matricula_venta, String id_usuario) {
        this.valorPago = valorPago;
        this.fechaPago = fechaPago;
        this.cedula_cliente = cedula_cliente;
        this.matricula_venta = matricula_venta;
        this.id_usuario = id_usuario;
    }

    public Number getValorPago() {
        return valorPago;
    }

    public void setValorPago(Number valorPago) {
        this.valorPago = valorPago;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Number getCedula_cliente() {
        return cedula_cliente;
    }

    public void setCedula_cliente(Number cedula_cliente) {
        this.cedula_cliente = cedula_cliente;
    }

    public Number getMatricula_venta() {
        return matricula_venta;
    }

    public void setMatricula_venta(Number matricula_venta) {
        this.matricula_venta = matricula_venta;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }
}
