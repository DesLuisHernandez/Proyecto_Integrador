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
    private int idTorre;
    private int idProyecto;
    private int numero_torre;
    private int numeroApto;

    public Torres(int idTorre, int idProyecto, int numero_torre, int numeroApto) {
        this.idTorre = idTorre;
        this.idProyecto = idProyecto;
        this.numero_torre = numero_torre;
        this.numeroApto = numeroApto;
    }

    public int getIdTorre() {
        return idTorre;
    }

    public void setIdTorre(int idTorre) {
        this.idTorre = idTorre;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public int getNumero_torre() {
        return numero_torre;
    }

    public void setNumero_torre(int numero_torre) {
        this.numero_torre = numero_torre;
    }

    public int getNumeroApto() {
        return numeroApto;
    }

    public void setNumeroApto(int numeroApto) {
        this.numeroApto = numeroApto;
    }

    @Override
    public String toString() {
        return "Torres{" + "idTorre=" + idTorre + ", idProyecto=" + idProyecto + ", numero_torre=" + numero_torre + ", numeroApto=" + numeroApto + '}';
    }
    
}
