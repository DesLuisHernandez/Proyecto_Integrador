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
    
    private int idProyecto;
    private int numero_torres;
    private int numeroApto; 

    public Proyectos(int idProyecto, int numero_torres, int numeroApto) {
        this.idProyecto = idProyecto;
        this.numero_torres = numero_torres;
        this.numeroApto = numeroApto;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public int getNumero_torres() {
        return numero_torres;
    }

    public void setNumero_torres(int numero_torres) {
        this.numero_torres = numero_torres;
    }

    public int getNumeroApto() {
        return numeroApto;
    }

    public void setNumeroApto(int numeroApto) {
        this.numeroApto = numeroApto;
    }

    @Override
    public String toString() {
        return "Proyectos{" + "idProyecto=" + idProyecto + ", numero_torres=" + numero_torres + ", numeroApto=" + numeroApto + '}';
    } 
}
