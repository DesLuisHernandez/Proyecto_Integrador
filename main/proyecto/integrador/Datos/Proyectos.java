/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.proyecto.integrador.Datos;

/**
 *
 * @author genny
 */
public class Proyectos {
    private String Nombre;
    private int cantTorres;
    private String idUsuario; 

    @Override
    public String toString() {
        return "Proyectos{" + "Nombre=" + Nombre + ", cantTorres=" + cantTorres + ", idUsuario=" + idUsuario + '}';
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getCantTorres() {
        return cantTorres;
    }

    public void setCantTorres(int cantTorres) {
        this.cantTorres = cantTorres;
    }

    public Proyectos(String Nombre, int cantTorres, String idUsuario) {
        this.Nombre = Nombre;
        this.cantTorres = cantTorres;
        this.idUsuario = idUsuario;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Proyectos() {
    }   
}