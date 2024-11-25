/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.proyecto.integrador.Datos;

/**
 *
 * @author genny
 */
public class Torres {
    private int numero_torre;
    private int cantidadAptos;
    private String id_Proyecto;

    public Torres() {
    }

    public Torres(int numero_torre, int cantidadAptos, String id_Proyecto) {
        this.numero_torre = numero_torre;
        this.cantidadAptos = cantidadAptos;
        this.id_Proyecto = id_Proyecto;
    }

    public int getNumero_torre() {
        return numero_torre;
    }

    public void setNumero_torre(int numero_torre) {
        this.numero_torre = numero_torre;
    }

    public int getCantidadAptos() {
        return cantidadAptos;
    }

    public void setCantidadAptos(int cantidadAptos) {
        this.cantidadAptos = cantidadAptos;
    }

    public String getId_Proyecto() {
        return id_Proyecto;
    }

    public void setId_Proyecto(String id_Proyecto) {
        this.id_Proyecto = id_Proyecto;
    }
}
