/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.proyecto.integrador.Datos;

/**
 *
 * @author genny
 */
public class Cliente {
    
    private String cedula;
    private String nombre;
    private String apellido; 
    private String direccion; 
    private String telefono; 
    private String correo; 
    private char sisben; 
    private char subsi_minis;

    public Cliente() {
    }
    
    public Cliente(String cedula, String nombre, String apellido, String direccion, String telefono, String correo, char sisben, char subsi_minis) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.sisben = sisben;
        this.subsi_minis = subsi_minis;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public char getSisben() {
        return sisben;
    }

    public void setSisben(char sisben) {
        this.sisben = sisben;
    }

    public char getSubsi_minis() {
        return subsi_minis;
    }

    public void setSubsi_minis(char subsi_minis) {
        this.subsi_minis = subsi_minis;
    }

    @Override
    public String toString() {
        return "Cliente{" + "cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + ", telefono=" + telefono + ", correo=" + correo + ", sisben=" + sisben + ", subsi_minis=" + subsi_minis + '}';
    } 
}
