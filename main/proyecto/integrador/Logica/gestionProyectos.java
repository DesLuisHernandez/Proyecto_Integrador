/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.proyecto.integrador.Logica;

import java.util.List;
import main.proyecto.integrador.Datos.Proyectos;
import main.proyecto.integrador.Datos.ProyectosDAO;


/**
 *
 * @author genny
 */
public class gestionProyectos {
    private ProyectosDAO proyectoDAO = new ProyectosDAO(); 
    
    public List<Proyectos> obtenerProyectos() {
        return proyectoDAO.listar();
    }  
    
    public boolean registrarProyectos(Proyectos proyecto) {
        return proyectoDAO.agregar(proyecto);
    }
}
